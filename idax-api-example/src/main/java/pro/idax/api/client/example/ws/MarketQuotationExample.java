package pro.idax.api.client.example.ws;

import com.alibaba.fastjson.JSON;
import pro.idax.api.client.example.config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.enums.DepthYEnum;
import pro.idax.api.client.enums.PeriodEnum;
import pro.idax.api.client.service.IdaxApiWebSocketClient;

import java.io.Closeable;

/**
 * @program: idax
 * @description: MarketQuotationExample
 * @author: zhuwei
 * @create: 2019/03/04 14:50
 */
@Slf4j
public class MarketQuotationExample {

    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{

        /**idaxSubXTicker**/
        idaxSubXTickerExample();

        /**idaxSubXDepth**/
        idaxSubXDepthExample();

        /**idaxSubXDepthY**/
        idaxSubXDepthYExample();

        /**idaxSubXKlineY**/
        idaxSubXKlineYExample();

    }


    /**
     * idaxSubXDepthYExample
     * idax_sub_X_ticker  Subscription quotation data
     */
    private static void idaxSubXTickerExample()throws Exception{

        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_ticker**/
        idaxApiWebSocketClient.onTickerEvent(symbol, response -> log.info("idaxSubXTickerExample response:{}",JSON.toJSON(response)));

    }


    /**
     * idaxSubXDepth
     * idax_sub_X_depth  Subscribe to market depth (200 incremental data return)
     */
    private static void idaxSubXDepthExample()throws Exception{

        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_depth**/
        Closeable closeable =idaxApiWebSocketClient.onDepthXEvent(symbol, response -> log.info("idaxSubXDepthExample response:{}",JSON.toJSON(response)));

        closeable.close();
    }


    /**
     * idaxSubXDepthYExample
     * idax_sub_X_depth_Y  Subscription market depth (1 push per second)
     */
    private static void idaxSubXDepthYExample()throws Exception{

        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_depth_Y**/
        Closeable closeable = idaxApiWebSocketClient.onDepthXYEvent(symbol,DepthYEnum.FIFTY.getCode(), response -> log.info("idaxSubXDepthYExample response:{}",JSON.toJSON(response)));

        closeable.close();
    }


    /**
     * idaxSubXDepthYExample
     * idax_sub_X_kline_Y  Subscribe K line data
     */
    private static void idaxSubXKlineYExample()throws Exception{

        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_kline_Y**/
        idaxApiWebSocketClient.onKLineEvent(symbol,PeriodEnum.ONE_WEEK, response -> log.info("idaxSubXKlineYExample response:{}",JSON.toJSON(response)));

    }
}
