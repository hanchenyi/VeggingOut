package com.example.demo.constant;

public enum CoinType {

    BTC("bpi");

    private String tickerType;

    CoinType(String tickerType) {
        this.tickerType = tickerType;
    }

    public String getTickerType() {
        return tickerType;
    }

    public void setTickerType(String tickerType) {
        this.tickerType = tickerType;
    }
}
