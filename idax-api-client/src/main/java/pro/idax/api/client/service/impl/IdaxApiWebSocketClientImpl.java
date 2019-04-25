package pro.idax.api.client.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import pro.idax.api.client.constant.IdaxApiConstants;
import pro.idax.api.client.enums.EventTypeEnum;
import pro.idax.api.client.enums.PeriodEnum;
import pro.idax.api.client.event.*;
import pro.idax.api.client.service.IdaxApiCallback;
import pro.idax.api.client.service.IdaxApiWebSocketClient;
import pro.idax.api.client.util.ObjectUtils;
import pro.idax.api.client.util.SignUtils;

import java.io.Closeable;
import java.util.List;
import java.util.Map;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@Slf4j
public class IdaxApiWebSocketClientImpl implements IdaxApiWebSocketClient, Closeable {

    public static volatile WebSocket webSocket;
    /**
     * client
     */
    private final OkHttpClient client;
    /**
     * API Key
     */
    private String apiKey;
    /**
     * Secret
     */
    private String secret;
    /**
     * api Base Url
     */
    private String apiBaseUrl;


    /**
     * IdaxApiWebSocketClientImpl
     *
     * @param client     client
     * @param apiKey     apiKey
     * @param secret     secret
     * @param apiBaseUrl apiBaseUrl
     */
    public IdaxApiWebSocketClientImpl(OkHttpClient client, String apiKey, String secret, String apiBaseUrl) {
        this.client = client;
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiBaseUrl = apiBaseUrl;
    }

    /**
     * onDepthXEvent
     *
     * @param symbol   symbol
     * @param callback the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onDepthXEvent(String symbol, IdaxApiCallback<DepthEvent> callback) {

        SendMessage sendMessage = new SendMessage();
        String event = EventTypeEnum.ADD_CHANNEL.getCode();
        sendMessage.setEvent(event);
        String channel = IdaxApiConstants.CHANNEL_DEPTH_X.replace("{symbol}", symbol);
        sendMessage.setChannel(channel);

        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, DepthEvent.class));
    }

    /**
     * onDepthXYEvent
     *
     * @param symbol   symbol
     * @param num      num
     * @param callback the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onDepthXYEvent(String symbol, Integer num, IdaxApiCallback<DepthEvent> callback) {
        final String event = EventTypeEnum.ADD_CHANNEL.getCode();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setEvent(event);
        String channel = IdaxApiConstants.CHANNEL_DEPTH_XY.replace("{symbol}", symbol).replace("{number}", String.valueOf(num));
        sendMessage.setChannel(channel);
        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, DepthEvent.class));
    }

    /**
     * onTickerEvent
     *
     * @param symbol   symbol
     * @param callback the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onTickerEvent(String symbol, IdaxApiCallback<TickerEventEntry> callback) {
        final String event = EventTypeEnum.ADD_CHANNEL.getCode();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setEvent(event);
        String channel = IdaxApiConstants.CHANNEL_TICKER.replace("{symbol}", symbol);
        sendMessage.setChannel(channel);
        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, TickerEventEntry.class));
    }

    /**
     * onKLineEvent
     *
     * @param symbol     market (one or coma-separated) symbol(s) to subscribe to
     * @param periodEnum kline period {@link PeriodEnum periodEnum}
     * @param callback   the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onKLineEvent(String symbol, PeriodEnum periodEnum, IdaxApiCallback<KlineEventEntry> callback) {
        final String event = EventTypeEnum.ADD_CHANNEL.getCode();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setEvent(event);
        String channel = IdaxApiConstants.CHANNEL_KLINE.replace("{symbol}", symbol).replace("{period}", periodEnum.getCode());
        sendMessage.setChannel(channel);
        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, KlineEventEntry.class));
    }

    /**
     * onTradeEvent
     *
     * @param symbol   symbol
     * @param callback the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onTradeEvent(String symbol, IdaxApiCallback<TradeEventEntry> callback) {
        final String event = EventTypeEnum.ADD_CHANNEL.getCode();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setEvent(event);
        String channel = IdaxApiConstants.CHANNEL_TRADE.replace("{symbol}", symbol);
        sendMessage.setChannel(channel);
        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, TradeEventEntry.class));
    }

    /**
     * onMyTradeEvent
     *
     * @param param    param
     * @param callback the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onMyTradeEvent(Map<String, Object> param, IdaxApiCallback<MyTradeEntry> callback) {
        final String event = EventTypeEnum.ADD_CHANNEL.getCode();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setEvent(event);
        sendMessage.setChannel(IdaxApiConstants.CHANNEL_MY_TRADE);
        sendMessage.setParameters(param);
        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, MyTradeEntry.class));
    }

    /**
     * onMyOrderEvent
     *
     * @param param    param
     * @param callback the callback to call on new events
     * @return Closeable
     */
    @Override
    public Closeable onMyOrderEvent(Map<String, Object> param, IdaxApiCallback<MyOrderEntry> callback) {

        final String event = EventTypeEnum.ADD_CHANNEL.getCode();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setEvent(event);
        sendMessage.setChannel(IdaxApiConstants.CHANNEL_MY_ORDER);
        sendMessage.setParameters(param);

        return createNewWebSocket(event, sendMessage, new IdaxApiWebSocketListener<>(callback, MyOrderEntry.class));
    }

    /**
     * createNewWebSocket
     *
     * @param channel     channel
     * @param sendMessage sendMessage
     * @param listener    listener
     * @return Closeable
     */
    private Closeable createNewWebSocket(String channel, SendMessage sendMessage, IdaxApiWebSocketListener<?> listener) {

        Request request = new Request.Builder().url(apiBaseUrl).build();
        String message = getMessage(sendMessage);

        log.info("request{}", message);

        getWebSocketInstance(request, listener).send(message);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };

    }

    /**
     * createNewWebSocket
     *
     * @param sendMessages sendMessages
     * @param listener     listener
     * @return Closeable
     */
    private Closeable createNewWebSocket(List<SendMessage> sendMessages, IdaxApiWebSocketListener<?> listener) {

        Request request = new Request.Builder().url(apiBaseUrl).build();
        String message = JSON.toJSONString(sendMessages);

        log.info("request{}", message);
        getWebSocketInstance(request, listener).send(message);

        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

    @Override
    public void close() {

    }

    /**
     * getMessage
     *
     * @param sendMessage sendMessage
     * @return String
     */
    private String getMessage(SendMessage sendMessage) {

        Map<String, Object> param = sendMessage.getParameters();
        if (sendMessage.getParameters() == null || sendMessage.getParameters().size() == 0) {
            return JSON.toJSONString(sendMessage, SerializerFeature.WriteMapNullValue);
        } else {
            String sortStr = ObjectUtils.sortMap(param);
            String sign = SignUtils.hmacSha256(sortStr, secret);
            param.put("sign", sign);
            sendMessage.setParameters(param);
            return JSON.toJSONString(sendMessage);
        }
    }

    /**
     * getWebSocketInstance
     *
     * @param request  request
     * @param listener listener
     * @return WebSocket
     */
    public WebSocket getWebSocketInstance(Request request, IdaxApiWebSocketListener<?> listener) {

        if (webSocket == null) {
            synchronized (IdaxApiWebSocketClientImpl.class) {
                if (webSocket == null) {
                    webSocket = client.newWebSocket(request, listener);
                }
            }
        }
        return webSocket;
    }

}
