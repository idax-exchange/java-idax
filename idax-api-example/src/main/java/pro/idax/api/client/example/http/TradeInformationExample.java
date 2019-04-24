package pro.idax.api.client.example.http;

import com.alibaba.fastjson.JSON;
import pro.idax.api.client.example.config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.domain.MyTradesRequest;
import pro.idax.api.client.entry.MyTradesEntry;
import pro.idax.api.client.entry.TradeEntry;
import pro.idax.api.client.enums.OrderSideEnum;
import pro.idax.api.client.service.IdaxApiRestClient;

/**
 * @program: TradeInformationExample
 * @description: Examples of how to obtain transaction information
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 14:17
 */
@Slf4j
public class TradeInformationExample {


    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**getTrade**/
        getTradeExample();

        /**getMyTrades***/
        getMyTradesExample();

    }

    /**
     * getTradeExample
     * Get Recently Trades
     */
    private static void getTradeExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        TradeEntry tradeEntry = idaxApiRestClient.getTradeEntry(symbol);

        log.info("getTradeEntry result:{}", JSON.toJSONString(tradeEntry));

    }

    /**
     * getMyTradesExample
     * Get my historical trading information
     */
    private static void getMyTradesExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        MyTradesRequest myTradesRequest = new MyTradesRequest();
        myTradesRequest.setKey(IdaxConfig.API_KEY);
        myTradesRequest.setPair(symbol);
        myTradesRequest.setOrderSide(OrderSideEnum.BUY.getCode());
        myTradesRequest.setCurrentPage(0);
        myTradesRequest.setPageLength(20);
        myTradesRequest.setStartDate(System.currentTimeMillis() - 10000);
        myTradesRequest.setEndDate(System.currentTimeMillis());
        myTradesRequest.setTimestamp(System.currentTimeMillis());

        /**Call remote interface**/
        MyTradesEntry myTradesEntry = idaxApiRestClient.getMyTrades(myTradesRequest);

        log.info("getMyTrades result:{}", JSON.toJSONString(myTradesEntry));

    }
}
