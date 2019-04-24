package com.idax.api.client.example.ws;

import com.alibaba.fastjson.JSON;
import com.idax.api.client.service.IdaxApiWebSocketClient;
import config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: idax
 * @description: TradeInformationExample
 * @author: zhuwei
 * @create: 2019/03/04 15:51
 */
@Slf4j
public class TradeInformationExample {


    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**myTrade**/
        myTradeExample();

    }

    /**
     * myTradeExample
     *
     */
    private static void myTradeExample(){

        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        Map<String,Object> param = new HashMap<>(30);
        param.put("apiKey",IdaxConfig.API_KEY);
        param.put("timestamp",System.currentTimeMillis());

        /**Subscribe to myTrade**/
        idaxApiWebSocketClient.onMyTradeEvent(param,response -> log.info(JSON.toJSONString(response)));
    }
}
