package com.example.demo.tutorial.model;

public enum Singleton {
    INSTANCE;

    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
