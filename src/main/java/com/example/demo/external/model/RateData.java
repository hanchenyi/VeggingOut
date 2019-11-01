package com.example.demo.external.model;

public class RateData {
    private String code;
    private String rate;
    public RateData() {
    }

    public RateData(String code, String rate) {
        this.code = code;
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "RateData{" +
                "code='" + code + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
