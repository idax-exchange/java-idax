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
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public class IdaxApiWebSocketListener<T> extends WebSocketListener {

    private IdaxApiCallback<T> callback;

    private Class<T> eventClass;

    private TypeReference<T> eventTypeReference;

    private boolean closing = false;

    /**
     * IdaxApiWebSocketListener
     *
     * @param callback   callback
     * @param eventClass eventClass
     */
    public IdaxApiWebSocketListener(IdaxApiCallback<T> callback, Class<T> eventClass) {
        this.callback = callback;
        this.eventClass = eventClass;
    }

    /**
     * IdaxApiWebSocketListener
     *
     * @param callback           callback
     * @param eventTypeReference eventTypeReference
     */
    public IdaxApiWebSocketListener(IdaxApiCallback<T> callback, TypeReference<T> eventTypeReference) {
        this.callback = callback;
        this.eventTypeReference = eventTypeReference;
    }


    /**
     * onOpen
     *
     * @param webSocket webSocket
     * @param response  response
     */
    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
    }

    /**
     * onMessage
     *
     * @param webSocket webSocket
     * @param text      text
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
     * @param webSocket webSocket
     * @param code      code
     * @param reason    reason
     */
    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    /**
     * onFailure
     *
     * @param webSocket webSocket
     * @param throwable throwable
     * @param response  response
     */
    @Override
    public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
        if (!closing) {
            callback.onFailure(throwable);
        }
    }
}