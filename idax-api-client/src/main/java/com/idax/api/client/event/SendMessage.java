package com.idax.api.client.event;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Admin
 * @Title: SendMessage
 * @ProjectName idax-java-api
 * @Description: TODO
 * @date 2018/12/514:05
 */
@Data
public class SendMessage implements Serializable {

    private String event;
    private String channel;
    private Map<String,Object> parameters;

}
