package com.bfxy.rabbit.common.serializer;

/**
 * 序列化和反序列化接口
 *
 * @author: HanYuXing
 * @date: 2022-01-06 14:27
 **/
public interface Serializer {

    byte[] serializerRaw(Object data);

    String serialize(Object data);

    <T> T deserialize(String content);

    <T> T deserialize(byte[] content);
}
