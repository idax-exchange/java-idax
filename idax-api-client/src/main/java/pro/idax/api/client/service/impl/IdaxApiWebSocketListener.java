package pro.idax.api.client.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import pro.idax.api.client.exception.IdaxApiException;
import pro.idax.api.client.service.IdaxApiCallback;

import java.io.IOException;


/**
 * @program: IdaxApiWebSocketListener
 * @description: Idax API WebSocket listener.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/4 17:10
 */
public class IdaxApiWebSocketListener<T> extends WebSocketListener {

    private IdaxApiCallback<T> callback;

    private Class<T> eventClass;

    private TypeReference<T> eventTypeReference;

    private boolean closing = false;

    /**
     * IdaxApiWebSocketListener
     * @param callback
     * @param eventClass
     */
    public IdaxApiWebSocketListener(IdaxApiCallback<T> callback, Class<T> eventClass) {
        this.callback = callback;
        this.eventClass = eventClass;
    }

    /**
     * IdaxApiWebSocketListener
     * @param callback
     * @param eventTypeReference
     */
    public IdaxApiWebSocketListener(IdaxApiCallback<T> callback, TypeReference<T> eventTypeReference) {
        this.callback = callback;
        this.eventTypeReference = eventTypeReference;
    }


    /**
     * onOpen
     *
     * @param webSocket
     * @param response
     */
    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
    }

    /**
     * onMessage
     *
     * @param webSocket
     * @param text
     */
    @Override
    public void onMessage(WebSocket webSocket, String text) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            T event = null;
            if (eventClass == null) {
                event = mapper.readValue(text, eventTypeReference);
            } else {
                event = mapper.readValue(text, eventClass);
            }
            callback.onResponse(event);
        } catch (IOException e) {
            throw new IdaxApiException(e);
        }
    }

    /**
     * onClosing
     *
     * @param webSocket
     * @param code
     * @param reason
     */
    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    /**
     * onFailure
     *
     * @param webSocket
     * @param t
     * @param response
     */
    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (!closing) {
            callback.onFailure(t);
        }
    }
}