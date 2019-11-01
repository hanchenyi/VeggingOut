package com.example.demo.external.model;

import java.util.List;

public class TickerData {
    private String tickerCode;
    private List<RateData> rateData;
    private String timeStamp;

    public TickerData() {
    }

    public String getTickerCode() {
        return tickerCode;
    }

    public void setTickerCode(String tickerCode) {
        this.tickerCode = tickerCode;
    }

    public List<RateData> getRateData() {
        return rateData;
    }

    public void setRateData(List<RateData> rateData) {
        this.rateData = rateData;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "TickerData{" +
                "tickerCode='" + tickerCode + '\'' +
                ", rateData=" + rateData +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
