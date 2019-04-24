package pro.idax.api.client.service.impl;


import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.domain.*;
import pro.idax.api.client.entry.*;
import pro.idax.api.client.service.IdaxApiRestClient;
import pro.idax.api.client.util.BeanUtil;
import pro.idax.api.client.util.CheckParamValidUtil;
import pro.idax.api.client.util.ObjectUtils;
import pro.idax.api.client.util.SignUtils;
import pro.idax.api.client.util.http.HttpRest;

import java.util.Map;

/**
 * @program: IdaxApiRestClientImpl
 * @description: Implementation of Idax's REST API using Retrofit with synchronous/blocking method calls.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
@Slf4j
public class IdaxApiRestClientImpl implements IdaxApiRestClient {

    private String apiKey;
    private String secret;
    private String apiBaseUrl;

    /**
     * IdaxApiRestClientImpl
     *
     * @param apiKey
     * @param secret
     */
    public IdaxApiRestClientImpl(String apiKey, String secret, String apiBaseUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiBaseUrl = apiBaseUrl;
    }


    /**
     * getOrderBook
     *
     * @param symbol ticker symbol (e.g. ETH_BTC)
     * @return OrderBook
     */
    @Override
    public OrderBookEntry getOrderBook(String symbol) {

        String url = apiBaseUrl + IdaxApiConstants.URL_DEPTH.replace("#{symbol}", symbol);

        return new HttpRest<OrderBookEntry>().get(url, OrderBookEntry.class);
    }

    /**
     * getTickerEntry
     *
     * @param symbol ticker symbol (e.g. ETH_BTC)
     * @return TickerEntry
     */
    @Override
    public TickerEntry getTickerEntry(String symbol) {

        String url = apiBaseUrl + IdaxApiConstants.URL_TICKER.replace("#{symbol}", symbol);

        return new HttpRest<TickerEntry>().get(url, TickerEntry.class);
    }

    /**
     * getKlineEntry
     *
     * @param kLineReuest
     * @return KlineEntry
     */
    @Override
    public KlineEntry getKlineEntry(KlineRequest kLineReuest) {

        Map<String, String> param = BeanUtil.transBean2MapString(kLineReuest);

        return new HttpRest<KlineEntry>().get(apiBaseUrl + IdaxApiConstants.URL_K_LINE, param, KlineEntry.class);

    }

    /**
     * getTradeEntry
     *
     * @param symbol trade symbol (e.g. ETH_BTC)
     * @return TradeEntry
     */
    @Override
    public TradeEntry getTradeEntry(String symbol) {

        String url = apiBaseUrl + IdaxApiConstants.URL_TRADE.replace("#{symbol}", symbol);

        return new HttpRest<TradeEntry>().get(url, TradeEntry.class);
    }

    /**
     * getPairEntry
     *
     * @return PairEntry
     */
    @Override
    public PairEntry getPairEntry() {

        return new HttpRest<PairEntry>().get(apiBaseUrl + IdaxApiConstants.URL_PAIR, PairEntry.class);
    }

    /**
     * getPairLimitEntry
     *
     * @param symbol pairlimit symbol (e.g. ETH_BTC)
     * @return PairLimitEntry
     */
    @Override
    public PairLimitEntry getPairLimitEntry(String symbol) {

        String url = apiBaseUrl + IdaxApiConstants.URL_PAIR_LIMIT.replace("#{symbol}", symbol);

        return new HttpRest<PairLimitEntry>().get(url, PairLimitEntry.class);
    }


    /**
     * getOrderList
     *
     * @param orderListRequest
     * @return OrderListEntry
     */
//    @Override
//    public OrderListEntry getOrderList(OrderListRequest orderListRequest) {
//
//        CheckParamValidUtil.checkParamValidGetOrderList(orderListRequest);
//        Map<String, Object> map = BeanUtil.transBean2Map(orderListRequest);
//        String sign = getSign(map);
//        orderListRequest.setSign(sign);
//
//        return new HttpRest<OrderListEntry>().post(apiBaseUrl + URL_ORDER_LIST, orderListRequest, OrderListEntry.class);
//    }

    /**
     * getOrderInfo
     *
     * @param orderInfoRequest
     * @return OrderInfoEntry
     */
    @Override
    public OrderInfoEntry getOrderInfo(OrderInfoRequest orderInfoRequest) {

        CheckParamValidUtil.checkParamValidGetOrderInfo(orderInfoRequest);
        Map<String, Object> map = BeanUtil.transBean2Map(orderInfoRequest);
        String sign = getSign(map);
        orderInfoRequest.setSign(sign);

        return new HttpRest<OrderInfoEntry>().post(apiBaseUrl + IdaxApiConstants.URL_ORDER_INFO, orderInfoRequest, OrderInfoEntry.class);
    }

    /**
     * getOrderHistory
     *
     * @param orderHistoryRequest
     * @return OrderHistoryEntry
     */
    @Override
    public OrderHistoryEntry getOrderHistory(OrderHistoryRequest orderHistoryRequest) {

        CheckParamValidUtil.checkParamValidGetOrderHistory(orderHistoryRequest);
        Map<String, Object> map = BeanUtil.transBean2Map(orderHistoryRequest);
        String sign = getSign(map);
        orderHistoryRequest.setSign(sign);

        return new HttpRest<OrderHistoryEntry>().post(apiBaseUrl + IdaxApiConstants.URL_ORDER_HISTORY, orderHistoryRequest, OrderHistoryEntry.class);
    }

    /**
     * getUserInfo
     *
     * @param userInfoRequest
     * @return UserInfoEntry
     */
    @Override
    public UserInfoEntry getUserInfo(UserInfoRequest userInfoRequest) {

        CheckParamValidUtil.checkParamValidGetUserInfo(userInfoRequest);
        Map<String, Object> map = BeanUtil.transBean2Map(userInfoRequest);
        String sign = getSign(map);
        userInfoRequest.setSign(sign);

        return new HttpRest<UserInfoEntry>().post(apiBaseUrl + IdaxApiConstants.URL_USER_INFO, userInfoRequest, UserInfoEntry.class);
    }

    /**
     * getTradeHistory
     *
     * @param tradeHistoryRequest
     * @return TradeHistoryEntry
     */
//    @Override
//    public TradeHistoryEntry getTradeHistory(TradeHistoryRequest tradeHistoryRequest) {
//
//        CheckParamValidUtil.checkParamValidGetTradeHistory(tradeHistoryRequest);
//        Map<String, Object> map = BeanUtil.transBean2Map(tradeHistoryRequest);
//        String sign = getSign(map);
//        tradeHistoryRequest.setSign(sign);
//
//        return new HttpRest<TradeHistoryEntry>().post(apiBaseUrl + URL_TRADE_HISTORY, tradeHistoryRequest, TradeHistoryEntry.class);
//    }

    /**
     * getMyTrades
     *
     * @param myTradesRequest
     * @return MyTradesEntry
     */
    @Override
    public MyTradesEntry getMyTrades(MyTradesRequest myTradesRequest) {

        Map<String, Object> map = BeanUtil.transBean2Map(myTradesRequest);
        String sign = getSign(map);
        myTradesRequest.setSign(sign);

        return new HttpRest<MyTradesEntry>().post(apiBaseUrl + IdaxApiConstants.URL_MY_TRADES, myTradesRequest, MyTradesEntry.class);
    }

    /**
     * placeOrder
     *
     * @param placeOrderRequest
     * @return PlaceOrderEntry
     */
    @Override
    public PlaceOrderEntry placeOrder(PlaceOrderRequest placeOrderRequest) {

        CheckParamValidUtil.checkParamValidPlaceOrder(placeOrderRequest);
        Map<String, Object> map = BeanUtil.transBean2Map(placeOrderRequest);
        String sign = getSign(map);
        placeOrderRequest.setSign(sign);

        return new HttpRest<PlaceOrderEntry>().post(apiBaseUrl + IdaxApiConstants.URL_PLACE_ORDER, placeOrderRequest, PlaceOrderEntry.class);
    }

    /**
     * cancelOrder
     *
     * @param cancelOrderRequest
     * @return CancelOrderEntry
     */
    @Override
    public CancelOrderEntry cancelOrder(CancelOrderRequest cancelOrderRequest) {

        CheckParamValidUtil.checkParamValidCancelOrder(cancelOrderRequest);
        Map<String, Object> map = BeanUtil.transBean2Map(cancelOrderRequest);
        String sign = getSign(map);
        cancelOrderRequest.setSign(sign);

        return new HttpRest<CancelOrderEntry>().post(apiBaseUrl + IdaxApiConstants.URL_CANCEL_ORDER, cancelOrderRequest, CancelOrderEntry.class);
    }

    /**
     * getSign
     *
     * @param map
     * @return String
     */
    private String getSign(Map<String, Object> map) {

        map.remove(IdaxApiConstants.SIGN);
        /**sort**/
        String param = ObjectUtils.sortMap(map);
        /**sign***/
        String sign = SignUtils.hmacSha256(param, secret);

        return sign;
    }

}
