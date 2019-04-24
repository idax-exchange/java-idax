package com.idax.api.client.service;

import com.idax.api.client.enums.PeriodEnum;
import com.idax.api.client.event.*;

import java.io.Closeable;
import java.util.List;
import java.util.Map;


/**
 * @program: IdaxApiWebSocketClient
 * @description: Idax API data streaming facade, supporting streaming of events through web sockets.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/4 17:10
 */
public interface IdaxApiWebSocketClient extends Closeable {

    /**
     * Open a new web socket to receive {@link DepthEvent depthEvents} on a callback.
     *
     * @param symbols  market (one or coma-separated) symbol(s) to subscribe to
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onDepthXEvent(String symbols, IdaxApiCallback<DepthEvent> callback);

    /**
     * Open a new web socket to receive {@link DepthEvent depthEvents} on a callback.
     *
     * @param symbols  market (one or coma-separated) symbol(s) to subscribe to
     * @param number   depth number
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onDepthXYEvent(String symbols, Integer number, IdaxApiCallback<DepthEvent> callback);

    /**
     * Open a new web socket to receive {@link TickerEventEntry tickerEventEntry} on a callback.
     *
     * @param symbols  market (one or coma-separated) symbol(s) to subscribe to
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onTickerEvent(String symbols, IdaxApiCallback<TickerEventEntry> callback);

    /**
     * Open a new web socket to receive {@link KlineEventEntry klineEventEntry} on a callback.
     *
     * @param periodEnum kline period {@link PeriodEnum periodEnum}
     * @param symbol     market (one or coma-separated) symbol(s) to subscribe to
     * @param callback   the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onKLineEvent(String symbol, PeriodEnum periodEnum, IdaxApiCallback<KlineEventEntry> callback);

    /**
     * Open a new web socket to receive {@link TradeEventEntry tradeEventEntry} on a callback.
     *
     * @param symbols  market (one or coma-separated) symbol(s) to subscribe to
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onTradeEvent(String symbols, IdaxApiCallback<TradeEventEntry> callback);

    /**
     * Open a new web socket to receive {@link TradeEventEntry tradeEventEntry} on a callback.
     *
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onMyTradeEvent(Map<String, Object> param, IdaxApiCallback<MyTradeEntry> callback);

    /**
     * Open a new web socket to receive {@link BatchRegisterEventEntry batchRegisterEventEntry} on a callback.
     *
     * @param callback the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onMyOrderEvent(Map<String, Object> param, IdaxApiCallback<MyOrderEntry> callback);



}
