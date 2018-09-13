package com.holley.emcpshare.model.dcs;

import java.io.Serializable;

public class DataItemValue implements Serializable {

    private static final long serialVersionUID = 1L;

    private String            di;
    private String            itemName;
    private String            charValue;
    private String            stringValue;
    private String            simpleStringValue;
    private String            unit;
    private byte[]            byteValue;
    private boolean           isValid;

    public String getSimpleStringValue() {
        return simpleStringValue;
    }

    public void setSimpleStringValue(String simpleStringValue) {
        this.simpleStringValue = simpleStringValue;
    }

    public int getByteLen() {
        if (byteValue == null) {
            return 0;
        } else {
            return byteValue.length;
        }
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDi() {
        return di;
    }

    public void setDi(char di) {

        this.di = String.format("%02x%02x", (di & 0xFF00) >> 8, di & 0x00FF);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getCharValue() {
        return charValue;
    }

    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public byte[] getByteValue() {
        return byteValue;
    }

    public void setByteValue(byte[] byteValue, int from, int datalen) {
        int len = Math.min(datalen, byteValue.length - from);
        this.byteValue = new byte[len];
        System.arraycopy(byteValue, from, this.byteValue, 0, len);
    }

    public void setDi(String di) {
        this.di = di;
    }

}
