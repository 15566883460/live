package com.dlyong.live.exception;

public class ParamException extends RuntimeException {

    public ParamException() {
        super("param is error");
    }

    public ParamException(String message) {
        super(message);
    }
}
