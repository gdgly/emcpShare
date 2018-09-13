package com.holley.emcpshare.dcs.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.holley.emcp.common.constants.DisconnectModeEnum;
import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcp.common.utils.DateUtil;
import com.holley.emcp.common.utils.NumberUtil;
import com.holley.emcp.common.utils.StringUtil;
import com.holley.emcpshare.model.dcs.DcsResultBean;

/**
 * 645协议
 * 
 * @author zdd
 */
public class ProtocolMeter645_2007Util {

    /**
     * 获取拉合闸的控制命令
     * 
     * @return
     */
    public static String packDisconnectDi(SwitchTypeEnum type, DisconnectModeEnum mode) {
        String result = null;
        // 控制命令类型(N1)
        if (SwitchTypeEnum.DISCONNECT == type) {// 远程拉闸
            result = "1A";
        } else if (SwitchTypeEnum.CONNECT == type) {// 允许合闸
            if (DisconnectModeEnum.METER_DISC_ALLOW == mode) {
                result = "1B";// 允许合闸
            } else if (DisconnectModeEnum.METER_DISC_CONN == mode) {
                result = "1C";// 直接合闸
            } else {
                return null;
            }
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
     * // 645拉闸报文例子:68 11 11 11 11 11 11 68 1C 10 33 33 33 33 33 33 33 33 4D 33 57 74 48 45 38 4B 55 16 <br>
     */

    public static String packDisconnect(String commaddr, String pa, String pwd, String n1) {
        String result = "";
        String temp = "";
        // 命令有效截至时间(N8~N3)
        Date now = DateUtil.addYears(new Date(), 1);

        String year = DateUtil.getYearValue(now) + "";
        year = year.substring(2, year.length());
        temp += NumberUtil.charPadStrict(year, 2, "0");

        String month = DateUtil.getMonthValue(now) + "";
        temp += NumberUtil.charPadStrict(month, 2, "0");

        String day = DateUtil.getDayValue(now) + "";
        temp += NumberUtil.charPadStrict(day, 2, "0");

        String hour = DateUtil.getHourValue(now) + "";
        temp += NumberUtil.charPadStrict(hour, 2, "0");

        String min = DateUtil.getMinuteValue(now) + "";
        temp += NumberUtil.charPadStrict(min, 2, "0");

        String sec = DateUtil.getSecondValue(now) + "";
        temp += NumberUtil.charPadStrict(sec, 2, "0");

        temp += "00";// N2:保留位

        // 控制命令类型(N1)
        temp += n1;

        // 操作者代码:C3C2C1C0
        temp += "00000000";

        // 密码处理:P2P1P0
        temp += StringUtil.isEmpty(pwd) ? "000000" : NumberUtil.charPadStrict(pwd, 6, "0");

        // 密级处理
        temp += StringUtil.isEmpty(pa) ? "00" : NumberUtil.charPadStrict(pa, 2, "0");

        // 透明转发内容,数据域全部要加33的,长度L之后 到 CS校验和之前
        result = ProtocolMeter645Helper.makeDataAdd33(temp);
        result += "101C68";// L:10

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
        // 数据标识DI3~DI0
        result = ProtocolMeter645Helper.makeDataAdd33(di);
        // 数据域长度
        result += "04";
        // 控制码
        result += "11";
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
        // 召读数据正常应答帧： "16 CS N8 N7...N1 DI3 DI2 DI1 DI0 L 91 68 A5 A4 A3 A2 A1 A0 68";
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
        if ("91".equalsIgnoreCase(c)) {// 正常应答
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
            index -= 8;
            String di = temp.substring(index, index + 8).toUpperCase();
            // 数据域
            String data = temp.substring(0, index);
            switch (di) {
                case "04000503":// 电表运行状态字3
                    return parseMeterRunStatus3(data);
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
     * 解析电表运行状态字3
     * 
     * @param value
     * @return
     */
    private static DcsResultBean parseMeterRunStatus3(String value) {
        DcsResultBean result = new DcsResultBean();
        if (StringUtil.isEmpty(value) || value.length() != 4) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        Map<String, Object> data = new HashMap<String, Object>();

        String temp = value.substring(2);
        int num = Integer.parseInt(temp, 16);
        temp = Integer.toBinaryString(num);
        temp = NumberUtil.charPadStrict(temp, 8, "0");

        String b = temp.substring(3, 4);
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
            if ("9C".equalsIgnoreCase(c)) {// 正常应答帧控制码C:9CH
                resultBean.setSuccess(true);
                return resultBean;
            }
        }
        resultBean.setSuccess(false);
        return resultBean;
    }

}
