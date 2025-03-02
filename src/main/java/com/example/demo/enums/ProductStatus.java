package com.example.demo.enums;

public enum ProductStatus {
    AVAILABLE("AVAILABLE", "可用"),
    DISCONTINUED("DISCONTINUED", "已下架"),
    OUT_OF_STOCK("OUT_OF_STOCK", "缺货");

    private final String code;
    private final String description;

    ProductStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
