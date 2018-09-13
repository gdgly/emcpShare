package com.holley.emcpshare.dcs.util;

import java.util.HashMap;
import java.util.Map;

import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcp.common.utils.NumberUtil;
import com.holley.emcp.common.utils.StringUtil;
import com.holley.emcpshare.model.dcs.DcsResultBean;

/**
 * 645-1997协议
 * 
 * @author zdd
 */
public class ProtocolMeter645_1997Util {

    /**
     * 获取拉合闸的控制命令
     * 
     * @return
     */
    public static String packDisconnectDi(SwitchTypeEnum type) {
        String result = null;
        if (SwitchTypeEnum.DISCONNECT == type) {// 远程拉闸
            result = "3355";
        } else if (SwitchTypeEnum.CONNECT == type) {// 远程合闸
            result = "9966";
        }
        return result;
    }

    /**
     * 跳合闸、报警、保电
     * 
     * @param commaddr
     * @param pa
     * @param pwd
     * @param n1
     * @return <br>
     * //645-1997拉闸报文格式:68 A0 A1 A2 A3 A4 A5 68 04 08 28 C0 P0 P1 P2 P3 55 33 CS 16<br>
     * //645-1997合闸报文格式:68 A0 A1 A2 A3 A4 A5 68 04 08 28 C0 P0 P1 P2 P3 66 99 CS 16<br>
     * //透明转发内容,数据域全部要加33的,控制码之后 到 校验和之前<br>
     * //645-1997拉闸报文例子:68 88 92 10 00 00 00 68 04 08 5B F3 33 33 33 33 88 66 0E 16<br>
     * //645-1997合闸报文例子:68 88 92 10 00 00 00 68 04 08 5B F3 33 33 33 33 99 CC 85 16<br>
     */

    public static String packDisconnect(String commaddr, String pa, String pwd, String n1) {
        String result = "";
        String temp = "";

        // 控制命令类型(N1)
        temp += n1;

        // 密码处理:P2P1P0
        temp += StringUtil.isEmpty(pwd) ? "000000" : NumberUtil.charPadStrict(pwd, 6, "0");

        // 密级处理：PA
        temp += StringUtil.isEmpty(pa) ? "00" : NumberUtil.charPadStrict(pa, 2, "0");

        // 标识编码：DI1 DI0
        temp += "C028";

        // 透明转发内容,数据域全部要加33的,长度L之后 到 CS校验和之前
        result = ProtocolMeter645Helper.makeDataAdd33(temp);

        // 数据长度:L(08),控制码：C(04),68
        result += "080468";// L:10

        // 处理表地址，A0A1A2A3A4A5,地位在前，比如表地址为112233445566，则应转为665544332211
        result += NumberUtil.charPadStrict(commaddr, 12, "0");
        result += "68";

        result = "16" + ProtocolMeter645Helper.makeCS(result) + result;
        return result;
    }

    /**
     * 召读数据
     * 
     * @param commaddr
     * @param di
     * @return
     */
    public static String packCallData(String commaddr, String di) {
        String result = "";
        // 数据标识DI1~DI0
        result = ProtocolMeter645Helper.makeDataAdd33(di);
        // 数据域长度
        result += "02";
        // 控制码
        result += "01";
        result += "68";
        // 表地址A5~A0
        result += NumberUtil.charPadStrict(commaddr, 12, "0");
        result += "68";
        result = "16" + ProtocolMeter645Helper.makeCS(result) + result;
        return result;
    }

    /**
     * 解析数据
     * 
     * @param di
     * @param value
     */
    public static DcsResultBean parseCallData(String value) {
        // 召读数据正常应答帧： "16 CS N8 N7...N1 DI1 DI0 L 81 68 A5 A4 A3 A2 A1 A0 68";
        DcsResultBean result = new DcsResultBean();
        if (StringUtil.isEmpty(value) || value.length() < 20) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        // 判断控制码C
        int index = value.length();
        index -= 18;
        String c = value.substring(index, index + 2);
        if ("81".equalsIgnoreCase(c)) {// 正常应答
            // 判断数据长度
            index -= 2;
            int len = Integer.parseInt(value.substring(index, index + 2), 16);
            if (len == 0) {// 无数据
                result.setSuccess(false);
                result.setMsg("暂无数据");
                return result;
            }
            // 应答透明转发内容,数据域全部要减33的,长度L之后 到 CS校验和之前
            index -= len * 2;
            String temp = value.substring(index, index + len * 2);
            temp = ProtocolMeter645Helper.makeDataSubtract33(temp);
            // 判断数据项
            index = temp.length();
            index -= 4;
            String di = temp.substring(index, index + 4).toUpperCase();
            // 数据域
            String data = temp.substring(0, index);
            switch (di) {
                case "C029":// 电表运行状态字3
                    return parseMeterRunStatus(data);
                default:
                    break;
            }
        } else {// 异常应答
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        result.setSuccess(false);
        result.setMsg("召读失败");
        return result;
    }

    /**
     * 解析电表运行状态字（拉合闸状态字）
     * 
     * @param value
     * @return
     */
    private static DcsResultBean parseMeterRunStatus(String value) {
        DcsResultBean result = new DcsResultBean();
        if (StringUtil.isEmpty(value) || value.length() != 2) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        Map<String, Object> data = new HashMap<String, Object>();

        String temp = "";
        int num = Integer.parseInt(value, 16);
        temp = Integer.toBinaryString(num);
        temp = NumberUtil.charPadStrict(temp, 8, "0");

        String b = temp.substring(6, 7);
        String desc = "";
        if ("1".equals(b)) {
            desc = "断电";
        } else {
            desc = "通电";
        }
        data.put("powerstatus", b);
        data.put("powerstatusname", desc);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    /**
     * 检验召读数据的应答帧
     * 
     * @param value
     * @return
     */
    private static DcsResultBean validCallResult(String value) {
        DcsResultBean result = new DcsResultBean();
        if (StringUtil.isEmpty(value) || value.length() < 14) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        int index = 0;
        // 68 A0 A1 A2 A3 A4 A5 68
        index += 16;
        // 91/B1/D1
        String temp = value.substring(index, index + 2);
        if ("91".equals(temp) || "B1".equals(temp)) {// 正常应答
            index += 2;
            int len = Integer.parseInt(temp.substring(index, index + 2));
            index += 2;// L
            if (len > 4) {
                len -= 4;// 减去DI的4个字节
                index += 8;// DI0~DI3
                String data = temp.substring(index, index + len * 2);
                result.setSuccess(true);
                result.setData(data);
            } else {
                result.setSuccess(false);
                result.setMsg("召读失败");
            }
        } else {// D1:异常应答
            result.setSuccess(false);
            result.setMsg("召读失败");
        }
        return result;
    }

    /**
     * 检验透明转发拉合闸的应答帧
     * 
     * @param value
     * @return
     */
    public static DcsResultBean validDisconnectResult(String value) {
        DcsResultBean resultBean = ProtocolGW09Helper.getParseGWTransitDataContent(value);
        if (!resultBean.isSuccess()) {
            return resultBean;
        }
        String data = (String) resultBean.getData();
        DcsResultBean checkResultBean = ProtocolMeter645Helper.checkRecvData(data);
        if (!checkResultBean.isSuccess()) {
            return checkResultBean;
        }
        data = checkResultBean.getData().toString();
        // 电表拉合闸成功返回的报文：16D2009C6811111111111168000C02
        if (data.length() == 24) {
            String c = value.substring(6, 8);
            if ("84".equalsIgnoreCase(c)) {// 正常应答帧控制码C:84H
                resultBean.setSuccess(true);
                return resultBean;
            }
        }
        resultBean.setSuccess(false);
        return resultBean;
    }

}
