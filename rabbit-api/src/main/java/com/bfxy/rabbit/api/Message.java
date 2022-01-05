package com.bfxy.rabbit.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: HanYuXing
 * @date: 2022-01-05 15:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = 841277940410721237L;

    /**
     * 消息唯一的ID
     */
    private String messageId;

    /**
     * 消息主题
     */
    private String topic;

    /**
     * 消息的路由规则
     */
    private String routingKey = "";

    /**
     * 消息的附加属性
     */
    private Map<String, Object> attributes = new HashMap<>();

    /**
     * 延迟消息的参数配置
     */
    private int delayMills;

    /**
     * 消息类型：默认为Confirm消息
     */
    private String messageType = MessageType.CONFIRM;
}
