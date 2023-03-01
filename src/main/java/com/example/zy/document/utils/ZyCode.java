package com.example.zy.document.utils;

public enum ZyCode {
    SUCCESS(200, "Success"),
    ERROR(500, "Error"),
    NOT_FOUND(404, "Not Found"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden");

    private final int code;
    private final String message;

    ZyCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
