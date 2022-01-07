package com.bfxy.rabbit.producer.entity;

import com.bfxy.rabbit.api.Message;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: HanYuXing
 * @date: 2022-01-07 9:42
 **/
@Getter
@Setter
public class BrokerMessage implements Serializable {

    private static final long serialVersionUID = -963297631656753834L;

    private String messageId;

    private Message message;

    private Integer tryCount = 0;

    private String status;

    private Date nextRetry;

    private Date createTime;

    private Date updateTime;
}
