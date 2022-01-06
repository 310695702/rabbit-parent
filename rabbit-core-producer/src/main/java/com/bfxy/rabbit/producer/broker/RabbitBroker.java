package com.bfxy.rabbit.producer.broker;

import com.bfxy.rabbit.api.Message;

/**
 * 具体发送不同种类型的接口
 *
 * @author: HanYuXing
 * @date: 2022-01-06 9:25
 **/
public interface RabbitBroker {

    void rapidSend(Message message);

    void confirmSend(Message message);

    void reliantSend(Message message);

    void sendMessages();

}
