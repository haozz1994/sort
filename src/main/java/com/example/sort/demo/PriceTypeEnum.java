package com.example.sort.demo;

public enum PriceTypeEnum {

    YQN_20GP("20GP","20DRY"),
    YQN_40GP("40GP","40DRY"),
    YQN_40HQ("40HQ","40HDRY"),
    YQN_45HQ("45HQ","45HDRY"),
    YQN_40NOR("40NOR","40NOR"),
    ;


    private String yqnCode;
    private String mskCode;


    PriceTypeEnum(String yqnCode, String mskCode) {
        this.yqnCode = yqnCode;
        this.mskCode = mskCode;
    }

    public String getYqnCode() {
        return yqnCode;
    }

    public void setYqnCode(String yqnCode) {
        this.yqnCode = yqnCode;
    }

    public String getMskCode() {
        return mskCode;
    }

    public void setMskCode(String mskCode) {
        this.mskCode = mskCode;
    }
}
