package com.example.zy.document.utils;

import lombok.Data;

@Data
public class ZyResponse<T> {
    private int code;
    private String message;
    private T data;

    public ZyResponse(ZyCode zyCode, T data) {
        this.code = zyCode.getCode();
        this.message = zyCode.getMessage();
        this.data = data;
    }

    public ZyResponse(ZyCode zyCode) {
        this.code = zyCode.getCode();
        this.message = zyCode.getMessage();
    }
}
