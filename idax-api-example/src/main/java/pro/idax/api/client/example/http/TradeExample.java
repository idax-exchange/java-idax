package pro.idax.api.client.example.http;

import com.alibaba.fastjson.JSON;
import pro.idax.api.client.example.config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.domain.CancelOrderRequest;
import pro.idax.api.client.domain.PlaceOrderRequest;
import pro.idax.api.client.entry.CancelOrderEntry;
import pro.idax.api.client.entry.PlaceOrderEntry;
import pro.idax.api.client.enums.OrderSideEnum;
import pro.idax.api.client.enums.OrderTypeEnum;
import pro.idax.api.client.service.IdaxApiRestClient;

import java.math.BigDecimal;


/**
 * @program: TradeExample
 * @description: Examples on how to place orders, cancel them.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:16
 */
@Slf4j
public class TradeExample {


    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**placeOrder**/
        placeOrderExample();

        /**cancelOrder***/
        cancelOrderExample();

    }


    /**
     * placeOrderExample
     * Create new order
     */
    private static void placeOrderExample() {

        /***Initialize the calling object**/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
        placeOrderRequest.setPair("APL_BTC");
        placeOrderRequest.setTimestamp(System.currentTimeMillis());
        placeOrderRequest.setAmount(new BigDecimal("1000"));
        String price = new BigDecimal("0.00000099").toPlainString();
        placeOrderRequest.setPrice(new BigDecimal(price));
        placeOrderRequest.setOrderType(OrderTypeEnum.LIMIT.getCode());
        placeOrderRequest.setOrderSide(OrderSideEnum.BUY.getCode());
        placeOrderRequest.setKey(IdaxConfig.API_KEY);

        /**Call remote interface**/
        PlaceOrderEntry placeOrderEntry = idaxApiRestClient.placeOrder(placeOrderRequest);

        log.info("placeOrder result:{}", JSON.toJSONString(placeOrderEntry));

    }

    /**
     * cancelOrderExample
     * Cancel orders
     */
    private static void cancelOrderExample() {

        /***init IdaxApiRestClient*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
        cancelOrderRequest.setKey(IdaxConfig.API_KEY);
        cancelOrderRequest.setTimestamp(System.currentTimeMillis());
        cancelOrderRequest.setOrderId("9798");

        /**Call remote interface**/
        CancelOrderEntry cancelOrderEntry = idaxApiRestClient.cancelOrder(cancelOrderRequest);

        log.info("cancelOrder result:{}", JSON.toJSONString(cancelOrderEntry));

    }

}
