package com.idax.api.client.service;

import com.idax.api.client.domain.*;
import com.idax.api.client.entry.*;

/**
 * @program: IdaxApiRestClientImpl
 * @description: Implementation of Idax's REST API using Retrofit with synchronous/blocking method calls.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
public interface IdaxApiRestClient {


    /**
     * Get order book of a symbol.
     *
     * @param symbol ticker symbol (e.g. ETH_BTC)
     * @return OrderBook
     */
    OrderBookEntry getOrderBook(String symbol);


    /**
     * Get ticker of a symbol.
     *
     * @param symbol ticker symbol (e.g. ETH_BTC)
     * @return TickerEntry
     */
    TickerEntry getTickerEntry(String symbol);

    /**
     * Get kline of a param.
     *
     * @param kLineReuest
     * @return KlineEntry
     */
    KlineEntry getKlineEntry(KlineRequest kLineReuest);

    /**
     * Get trade of a symbol.
     *
     * @param symbol trade symbol (e.g. ETH_BTC)
     * @return TradeEntry
     */
    TradeEntry getTradeEntry(String symbol);

    /**
     * Get pair .
     *
     * @return PairEntry
     */
    PairEntry getPairEntry();

    /**
     * Get pairlimit of a symbol.
     *
     * @param symbol pairlimit symbol (e.g. ETH_BTC)
     * @return PairLimitEntry
     */
    PairLimitEntry getPairLimitEntry(String symbol);

    /**
     * get Order List
     *This interface is obsoleted
     * @param orderListRequest
     * @return OrderListEntry
     * @link com.idax.api.client.domain.order.OrderListRequest
     */
//    OrderListEntry getOrderList(OrderListRequest orderListRequest);

    /**
     * get order info
     *
     * @param orderInfoRequest
     * @return OrderInfoEntry
     * @link com.idax.api.client.domain.order.OrderInfoRequest
     */
    OrderInfoEntry getOrderInfo(OrderInfoRequest orderInfoRequest);

    /**
     * get order history of { OrderHistoryRequest}
     *
     * @param orderHistoryRequest
     * @return OrderHistoryEntry
     */
    OrderHistoryEntry getOrderHistory(OrderHistoryRequest orderHistoryRequest);

    /**
     * get user info of { UserInfoRequest}
     *
     * @param userInfoRequest
     * @return UserInfoEntry
     */
    UserInfoEntry getUserInfo(UserInfoRequest userInfoRequest);


    /**
     * get trade history of { TradeHistoryRequest}
     *This interface is obsoleted
     * @param tradeHistoryRequest
     * @return TradeHistoryEntry
     */
//    TradeHistoryEntry getTradeHistory(TradeHistoryRequest tradeHistoryRequest);

    /**
     * getMyTrades
     *
     * @param myTradesRequest
     * @return MyTradesEntry
     */
    MyTradesEntry getMyTrades(MyTradesRequest myTradesRequest);

    /**
     * order place in Idax of { PlaceOrderRequest}
     *
     * @param placeOrderRequest
     * @return PlaceOrderEntry
     */
    PlaceOrderEntry placeOrder(PlaceOrderRequest placeOrderRequest);


    /**
     * cancel order in Idax of{@link CancelOrderRequest}
     *
     * @param cancelOrderRequest
     * @return CancelOrderEntry
     */
    CancelOrderEntry cancelOrder(CancelOrderRequest cancelOrderRequest);


}
