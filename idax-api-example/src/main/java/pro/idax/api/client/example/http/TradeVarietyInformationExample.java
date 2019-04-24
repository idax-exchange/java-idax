package pro.idax.api.client.example.http;

import com.alibaba.fastjson.JSON;
import pro.idax.api.client.example.config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.entry.PairEntry;
import pro.idax.api.client.entry.PairLimitEntry;
import pro.idax.api.client.service.IdaxApiRestClient;

/**
 * @program: TradeVarietyInformationExample
 * @description: Examples of how to obtain trade variety information
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/27 10:34
 */
@Slf4j
public class TradeVarietyInformationExample {


    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**getPair**/
        getPairExample();

        /**getPairLimit**/
        getPairLimitExample();

    }

    /**
     * getPairExample
     * All trading pairs supported by exchanges
     */
    private static void getPairExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Call remote interface**/
        PairEntry pairEntry = idaxApiRestClient.getPairEntry();

        log.info("getPairEntry result:{}", JSON.toJSONString(pairEntry));

    }

    /**
     * getPairLimitExample
     * Gets the maximum, minimum, price, and quantity of the supported transaction pairs
     */
    private static void getPairLimitExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        PairLimitEntry pairLimitEntry = idaxApiRestClient.getPairLimitEntry(symbol);

        log.info("getPairLimitEntry result:{}", JSON.toJSONString(pairLimitEntry));

    }
}
