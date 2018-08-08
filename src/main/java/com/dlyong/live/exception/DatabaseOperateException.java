package com.dlyong.live.exception;

public class DatabaseOperateException extends RuntimeException {

    public DatabaseOperateException() {
        super("数据库操作异常");
    }

    public DatabaseOperateException(String message) {
        super(message);
    }
}
