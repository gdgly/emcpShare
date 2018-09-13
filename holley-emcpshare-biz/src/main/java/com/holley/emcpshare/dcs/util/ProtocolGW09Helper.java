package com.holley.emcpshare.dcs.util;

import com.holley.emcp.common.utils.NumberUtil;
import com.holley.emcp.common.utils.StringUtil;
import com.holley.emcpshare.model.dcs.DcsResultBean;
import com.holley.emcpshare.model.dcs.PointDisconnDTO;

/**
 * 645协议
 * 
 * @author zdd
 */
public class ProtocolGW09Helper {

    /**
     * 终端透明转发数据帧(通用部分)
     * 
     * @param con
     * @param dataLength
     * @return
     */
    public static String makeGWTransitDataFrame(PointDisconnDTO con, int dataLength) {
        String fvalue = "";
        String temp = "";
        // 终端通信端口号：数据范围1～31
        fvalue = NumberUtil.num2PadString(con.getCommport(), 16, 2, "0");
        // 透明转发通信控制字
        // D7~D5:波特率 ,0～7依次表示300，600，1200，2400，4800，7200，9600，19200,一般的约定 97表是1200 07表2400
        temp += NumberUtil.num2PadString(con.getCommrate(), 2, 3, "0");
        // D4:停止位,0/1：1/2停止位,645电表的停止位位1位 (0)
        // D3:有无校验,0/1:无/有校验,645电表:有校验(1)
        // D2：奇偶校验，0/1:偶/奇校验,645电表:偶校验(0)
        // D1D0:数据位,0～3:5-8位数,645电表：8位(11)
        temp += "01011";
        fvalue = NumberUtil.num2PadString(Integer.parseInt(temp, 2), 16, 2, "0") + fvalue;
        // 透明转发接收等待报文超时时间:120s(F8)
        fvalue = "F8" + fvalue;
        // 透明转发接收等待字节超时时间:10*10ms(0A)
        fvalue = "0A" + fvalue;
        // 透明转发内容字节数k(2个字节)
        fvalue = NumberUtil.charPadStrict(NumberUtil.num2PadString(dataLength, 16, 4, "0"), 4, "0") + fvalue;
        return fvalue;
    }

    /**
     * 得到透明转发应答内容
     * 
     * @param value
     * @return
     */
    public static DcsResultBean getParseGWTransitDataContent(String value) {
        DcsResultBean result = new DcsResultBean();
        if (StringUtil.isEmpty(value) || value.length() < 6) {
            result.setSuccess(false);
            result.setMsg("应答非法");
            return result;
        }
        int index = value.length();

        // 终端通信端口号
        index -= 2;

        // 透明转发内容字节数k
        index -= 4;

        int len = Integer.parseInt(value.substring(index, index + 4), 16);

        // 透明转发内容
        String data = value.substring(0, index);

        if (data.length() != len * 2) {
            result.setSuccess(false);
            result.setMsg("应答非法");
            return result;
        }
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

}
