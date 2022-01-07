package com.bfxy.rabbit.producer.service;

import com.bfxy.rabbit.producer.constant.BrokerMessageStatus;
import com.bfxy.rabbit.producer.entity.BrokerMessage;
import com.bfxy.rabbit.producer.mapper.BrokerMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: HanYuXing
 * @date: 2022-01-07 11:25
 **/
@Service
public class MessageStoreService {

    @Autowired
    BrokerMessageMapper brokerMessageMapper;

    public int insert(BrokerMessage brokerMessage) {
        return this.brokerMessageMapper.insert(brokerMessage);
    }

    public void success(String messageId) {
        this.brokerMessageMapper.changeBrokerMessageStatus(messageId,
                BrokerMessageStatus.SEND_OK.getCode(),
                new Date());
    }

    public void failure(String messageId) {
        this.brokerMessageMapper.changeBrokerMessageStatus(messageId,
                BrokerMessageStatus.SEND_FAIL.getCode(),
                new Date());
    }
}
