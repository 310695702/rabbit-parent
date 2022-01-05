package com.bfxy.rabbit.api;

import com.bfxy.rabbit.api.exception.MessageRunTimeException;

import java.util.List;

/**
 * @author: HanYuXing
 * @date: 2022-01-05 16:49
 **/
public interface MessageProducer {

    /**
     * 消息的发送附带SendCallback回调执行业务逻辑处理
     *
     * @param message
     * @param sendCallback
     * @throws MessageRunTimeException
     */
    void send(Message message, SendCallback sendCallback) throws MessageRunTimeException;

    /**
     * Message消息的发送
     *
     * @param message
     * @throws MessageRunTimeException
     */
    void send(Message message) throws MessageRunTimeException;

    /**
     * Message消息的批量发送
     *
     * @param messages
     * @throws MessageRunTimeException
     */
    void send(List<Message> messages) throws MessageRunTimeException;


}
