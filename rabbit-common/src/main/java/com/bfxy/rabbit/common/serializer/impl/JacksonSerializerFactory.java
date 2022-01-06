package com.bfxy.rabbit.common.serializer.impl;

import com.bfxy.rabbit.api.Message;
import com.bfxy.rabbit.common.serializer.Serializer;
import com.bfxy.rabbit.common.serializer.SerializerFactory;

/**
 * @author: HanYuXing
 * @date: 2022-01-06 14:47
 **/
public class JacksonSerializerFactory implements SerializerFactory {

    public static final JacksonSerializerFactory INSTANCE = new JacksonSerializerFactory();

    @Override
    public Serializer create() {
        return JacksonSerializer.createParametricType(Message.class);
    }

}
