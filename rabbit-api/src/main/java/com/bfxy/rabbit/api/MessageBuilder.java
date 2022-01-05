package com.bfxy.rabbit.api;

import com.bfxy.rabbit.api.exception.MessageRunTimeException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: HanYuXing
 * @date: 2022-01-05 16:12
 **/
public class MessageBuilder {

    private String messageId;
    private String topic;
    private String routingKey = "";
    private Map<String, Object> attributes = new HashMap<>();
    private int delayMills;
    private String messageType = MessageType.CONFIRM;

    private MessageBuilder() {

    }

    public static MessageBuilder create() {
        return new MessageBuilder();
    }

    public MessageBuilder withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public MessageBuilder withMessageTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public MessageBuilder withMessageRoutingKey(String routingKey) {
        this.routingKey = routingKey;
        return this;
    }

    public MessageBuilder withMessageAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }

    public MessageBuilder withMessageAttributes(String key, Object value) {
        this.attributes.put(key, value);
        return this;
    }

    public MessageBuilder withMessageDelayMills(int delayMills) {
        this.delayMills = delayMills;
        return this;
    }

    public MessageBuilder withMessageMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public Message build() {

        if (messageId == null) {
            messageId = UUID.randomUUID().toString();
        }

        if (topic == null) {
            throw new MessageRunTimeException("topic is null");
        }

        Message message = new Message(messageId, topic, routingKey, attributes, delayMills, messageType);
        return message;
    }
}
