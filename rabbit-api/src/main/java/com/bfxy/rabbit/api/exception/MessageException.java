package com.bfxy.rabbit.api.exception;

/**
 * @author: HanYuXing
 * @date: 2022-01-05 16:44
 **/
public class MessageException extends Exception {

    private static final long serialVersionUID = 6347951066190728758L;

    public MessageException() {
        super();
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }
}
