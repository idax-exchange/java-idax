package pro.idax.api.client.service;

import pro.idax.api.client.domain.*;
import pro.idax.api.client.entry.*;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
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
     * @param kLineReuest kLineReuest
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
     * get order info
     *
     * @param orderInfoRequest orderInfoRequest
     * @return OrderInfoEntry
     */
    OrderInfoEntry getOrderInfo(OrderInfoRequest orderInfoRequest);

    /**
     * get order history of { OrderHistoryRequest}
     *
     * @param orderHistoryRequest orderHistoryRequest
     * @return OrderHistoryEntry
     */
    OrderHistoryEntry getOrderHistory(OrderHistoryRequest orderHistoryRequest);

    /**
     * get user info of { UserInfoRequest}
     *
     * @param userInfoRequest userInfoRequest
     * @return UserInfoEntry
     */
    UserInfoEntry getUserInfo(UserInfoRequest userInfoRequest);


    /**
     * getMyTrades
     *
     * @param myTradesRequest myTradesRequest
     * @return MyTradesEntry
     */
    MyTradesEntry getMyTrades(MyTradesRequest myTradesRequest);

    /**
     * order place in Idax of { PlaceOrderRequest}
     *
     * @param placeOrderRequest placeOrderRequest
     * @return PlaceOrderEntry
     */
    PlaceOrderEntry placeOrder(PlaceOrderRequest placeOrderRequest);


    /**
     * cancel order in Idax of{@link CancelOrderRequest}
     *
     * @param cancelOrderRequest cancelOrderRequest
     * @return CancelOrderEntry
     */
    CancelOrderEntry cancelOrder(CancelOrderRequest cancelOrderRequest);


}
