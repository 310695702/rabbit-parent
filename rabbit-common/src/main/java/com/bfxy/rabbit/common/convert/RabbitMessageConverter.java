package com.bfxy.rabbit.common.convert;

import com.google.common.base.Preconditions;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * 装饰者模式
 *
 * @author: HanYuXing
 * @date: 2022-01-06 16:53
 **/
public class RabbitMessageConverter implements MessageConverter {

    private GenericMessageConverter delegate;

    private final String DEFAULT_EXPIRE = String.valueOf(24 * 60 * 60 * 1000);

    public RabbitMessageConverter(GenericMessageConverter genericMessageConverter) {
        Preconditions.checkNotNull(genericMessageConverter);
        this.delegate = genericMessageConverter;
    }

    @Override
    public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
        messageProperties.setExpiration(DEFAULT_EXPIRE);
        return this.delegate.toMessage(o, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        com.bfxy.rabbit.api.Message msg = (com.bfxy.rabbit.api.Message) this.delegate.fromMessage(message);
        return msg;
    }
}
