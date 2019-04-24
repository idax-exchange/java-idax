package pro.idax.api.client.example.http;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.domain.OrderHistoryRequest;
import pro.idax.api.client.domain.OrderInfoRequest;
import pro.idax.api.client.entry.OrderHistoryEntry;
import pro.idax.api.client.entry.OrderInfoEntry;
import pro.idax.api.client.example.config.IdaxConfig;
import pro.idax.api.client.service.IdaxApiRestClient;

/**
 * @program: OrderExample
 * @description: Examples of how to obtain order information
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 13:44
 */
@Slf4j
public class OrderExample {

    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**getOrderInfo**/
        getOrderInfoExample();

        /**getOrderHistory***/
        getOrderHistoryExample();

    }

    /**
     * getOrderInfoExample
     * Get Order Info
     */
    private static void getOrderInfoExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        OrderInfoRequest orderInfoRequest = new OrderInfoRequest();
        orderInfoRequest.setKey(IdaxConfig.API_KEY);
        orderInfoRequest.setPair(symbol);
        orderInfoRequest.setPageIndex(1);
        orderInfoRequest.setPageSize(20);
        orderInfoRequest.setTimestamp(System.currentTimeMillis());
        orderInfoRequest.setOrderId(9799L);

        /**Call remote interface**/
        OrderInfoEntry orderInfoEntry = idaxApiRestClient.getOrderInfo(orderInfoRequest);

        log.info("getOrderInfo result:{}", JSON.toJSONString(orderInfoEntry));

    }


    /**
     * getOrderHistoryExample
     * Get historical order information and return information only for the last two days
     */
    private static void getOrderHistoryExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        OrderHistoryRequest orderHistoryRequest = new OrderHistoryRequest();
        orderHistoryRequest.setCurrentPage(1);
        orderHistoryRequest.setKey(IdaxConfig.API_KEY);
        orderHistoryRequest.setOrderState(-1);
        orderHistoryRequest.setPair(symbol);
        orderHistoryRequest.setTimestamp(System.currentTimeMillis());
        orderHistoryRequest.setPageLength(10);

        /**Call remote interface**/
        OrderHistoryEntry orderHistoryEntry = idaxApiRestClient.getOrderHistory(orderHistoryRequest);

        log.info("getOrderHistory result:{}", JSON.toJSONString(orderHistoryEntry));

    }
}
