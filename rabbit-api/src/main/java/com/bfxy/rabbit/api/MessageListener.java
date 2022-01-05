package com.bfxy.rabbit.api;

/**
 * 消费者监听消息
 *
 * @author: HanYuXing
 * @date: 2022-01-05 16:50
 **/
public interface MessageListener {

    void onMessage(Message message);
}
