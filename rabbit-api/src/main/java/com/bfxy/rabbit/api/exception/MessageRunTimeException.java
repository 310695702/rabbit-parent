package com.bfxy.rabbit.api.exception;

/**
 * 运行时异常
 *
 * @author: HanYuXing
 * @date: 2022-01-05 16:46
 **/
public class MessageRunTimeException extends RuntimeException {

    private static final long serialVersionUID = 8651828913888663267L;

    public MessageRunTimeException() {
        super();
    }

    public MessageRunTimeException(String message) {
        super(message);
    }

    public MessageRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageRunTimeException(Throwable cause) {
        super(cause);
    }
}
