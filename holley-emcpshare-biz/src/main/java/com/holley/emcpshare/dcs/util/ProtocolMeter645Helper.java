package com.holley.emcpshare.dcs.util;

import com.holley.emcp.common.utils.NumberUtil;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.platform.common.util.StringUtil;

/**
 * 645协议
 * 
 * @author zdd
 */
public class ProtocolMeter645Helper {

    /**
     * 求校验位
     * 
     * @param data：除去CS 和 16H的数据帧
     * @param len
     * @return
     */
    public static String makeCS(String data) {
        String result = "";
        // 从68开始到校验位之前进行求和，求和超过FF则取低两位，如求和结果为12A，则校验位为2A
        int num = 0;
        for (int i = 0; i < data.length() / 2; i++) {
            num = num + Integer.parseInt(data.substring(i * 2, (i + 1) * 2), 16);
        }
        // 将求和结果转化成16进制
        result = NumberUtil.num2PadString(num, 16, 2, "0");
        result = NumberUtil.charPadStrict(result, 2, "0");
        return result;
    }

    /**
     * 透明转发内容,数据域全部要加33的,长度L之后 到 CS校验和之前
     * 
     * @param data
     * @return
     */
    public static String makeDataAdd33(String data) {
        String result = "";
        int num = 0;
        for (int i = 0; i < data.length() / 2; i++) {
            num = Integer.parseInt(data.substring(i * 2, i * 2 + 2), 16) + 51;
            result += NumberUtil.charPadStrict(NumberUtil.num2PadString(num, 16, 2, "0"), 2, "0");
        }
        return result;
    }

    /**
     * 应答透明转发内容,数据域全部要减33的,长度L之后 到 CS校验和之前
     * 
     * @param data
     * @return
     */
    public static String makeDataSubtract33(String data) {
        String result = "";
        int num = 0;
        for (int i = 0; i < data.length() / 2; i++) {
            num = Integer.parseInt(data.substring(i * 2, i * 2 + 2), 16) - 51;
            result += NumberUtil.charPadStrict(NumberUtil.num2PadString(num, 16, 2, "0"), 2, "0");
        }
        return result;
    }

    /**
     * 校验电表应答的报文，并处理前导帧
     * 
     * @param data
     * @return
     */
    public static DcsResultBean checkRecvData(String data) {
        DcsResultBean result = new DcsResultBean();
        if (StringUtil.isEmpty(data) || data.length() < 16) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        // 68 A5 A4 A3 A2 A1 A0 68
        // 645-2007例子：16 5E 33 33 33 33 33 C3 34 33 08 91 68 22 22 22 22 22 22 68 FE FE FE FE FE
        // 645-1997例子：16 C2 33 33 33 33 B4 34 06 81 68 00 00 00 22 85 10 68 FE FE FE FE FE

        // 例子后面的5个字节EF为前导帧

        // (1)找到第一个68(从右到左)
        int index = data.lastIndexOf("68");
        if (index < 0) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        // (2)找到第二个68(从右到左)
        int index2 = data.indexOf("68", index - 14);
        if (index2 < 0 || index != index2 + 14) {
            result.setSuccess(false);
            result.setMsg("召读失败");
            return result;
        }
        // (3)处理前导符，有些电表应答的报文中会带有多个字节的前导符EF，则去掉前导帧
        data = data.substring(0, index + 2);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }
}
