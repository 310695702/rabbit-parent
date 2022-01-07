package com.bfxy.rabbit.producer.broker;

import com.bfxy.rabbit.api.Message;
import com.bfxy.rabbit.api.MessageType;
import com.bfxy.rabbit.producer.constant.BrokerMessageConst;
import com.bfxy.rabbit.producer.constant.BrokerMessageStatus;
import com.bfxy.rabbit.producer.entity.BrokerMessage;
import com.bfxy.rabbit.producer.service.MessageStoreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: HanYuXing
 * @date: 2022-01-06 9:28
 **/
@Slf4j
@Component
public class RabbitBrokerImpl implements RabbitBroker {

    @Autowired
    private RabbitTemplateContainer rabbitTemplateContainer;

    @Autowired
    private MessageStoreService messageStoreService;

    /**
     * 迅速发消息
     *
     * @param message
     */
    @Override
    public void rapidSend(Message message) {
        message.setMessageType(MessageType.RAPID);
        sendKernel(message);
    }

    /**
     * 发送消息的核心方法
     *
     * @param message
     */
    private void sendKernel(Message message) {
        AsyncBaseQueue.submit(() -> {
            CorrelationData correlationData = new CorrelationData(String.format("%s#%s", message.getMessageId(),
                    System.currentTimeMillis()));
            String topic = message.getTopic();
            String routingKey = message.getRoutingKey();
            RabbitTemplate rabbitTemplate = rabbitTemplateContainer.getTemplate(message);
            rabbitTemplate.convertAndSend(topic, routingKey, message, correlationData);
            log.info("#RabbitBrokerImpl.sendKernel# send to rabbitmq,messageId:{}", message.getMessageId());
        });
    }

    @Override
    public void confirmSend(Message message) {
        message.setMessageType(MessageType.CONFIRM);
        sendKernel(message);
    }

    @Override
    public void reliantSend(Message message) {
        message.setMessageType(MessageType.RELIANT);
        Date now = new Date();
        BrokerMessage brokerMessage = new BrokerMessage();
        brokerMessage.setMessageId(message.getMessageId());
        brokerMessage.setStatus(BrokerMessageStatus.SENDING.getCode());
        brokerMessage.setNextRetry(DateUtils.addMinutes(now, BrokerMessageConst.TIMEOUT));
        brokerMessage.setCreateTime(now);
        brokerMessage.setUpdateTime(now);
        brokerMessage.setMessage(message);
        messageStoreService.insert(brokerMessage);
        sendKernel(message);
    }

    @Override
    public void sendMessages() {

    }
}
