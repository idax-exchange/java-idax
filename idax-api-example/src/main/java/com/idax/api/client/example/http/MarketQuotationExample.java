package com.idax.api.client.example.http;

import com.alibaba.fastjson.JSON;
import com.idax.api.client.service.IdaxApiRestClient;
import com.idax.api.client.constant.IdaxApiConstants;
import com.idax.api.client.domain.KlineRequest;
import com.idax.api.client.entry.KlineEntry;
import com.idax.api.client.entry.OrderBookEntry;
import com.idax.api.client.entry.TickerEntry;
import com.idax.api.client.enums.PeriodEnum;
import config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: MarketQuotationExample
 * @description: Examples of how to obtain market quotation information
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@Slf4j
public class MarketQuotationExample {

    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**getTickerExample**/
//        getTickerExample();

        /**getOrderBook**/
        getOrderBookExample();

        /**getKline**/
//        getKlineExample();
    }

    /**
     * getTickerExample
     * Get the price of specific ticker
     */
    private static void getTickerExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        TickerEntry tickerEntry = idaxApiRestClient.getTickerEntry(symbol);

        log.info("getTicker result:{}", JSON.toJSONString(tickerEntry));

    }

    /**
     * getOrderBookExample
     * Get the market depth for specific market.
     */
    private static void getOrderBookExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        OrderBookEntry orderBook = idaxApiRestClient.getOrderBook(symbol);

        log.info("getOrderBook result:{}", JSON.toJSONString(orderBook));

    }


    /**
     * getKlineExample
     * Get kline data
     */
    private static void getKlineExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        KlineRequest kLineRequest = new KlineRequest();
        kLineRequest.setPair(symbol);
        kLineRequest.setPeriod(PeriodEnum.ONE_WEEK.getCode());
        kLineRequest.setSize(10);
        kLineRequest.setSince(System.currentTimeMillis());

        /**Call remote interface**/
        KlineEntry klineEntry = idaxApiRestClient.getKlineEntry(kLineRequest);

        log.info("getKlineEntry result:{}", JSON.toJSONString(klineEntry));

    }

}
