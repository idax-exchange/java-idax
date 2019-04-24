package pro.idax.api.client.example.ws;

import com.alibaba.fastjson.JSON;
import pro.idax.api.client.example.config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.service.IdaxApiWebSocketClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: idax
 * @description: OrderExample
 * @author: zhuwei
 * @create: 2019/03/04 15:52
 */
@Slf4j
public class OrderExample {

    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{

        /**myOrder**/
        myOrderExample();

    }

    /**
     * myOrderExample
     *
     */
    private static void myOrderExample()throws Exception{

        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        Map<String,Object> param = new HashMap<>(30);
        param.put("apiKey",IdaxConfig.API_KEY);
        param.put("timestamp",System.currentTimeMillis());

        /**Subscribe to myOrder**/
        idaxApiWebSocketClient.onMyOrderEvent(param, response -> log.info(JSON.toJSONString(response)));

    }




}
