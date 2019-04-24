package config;

import com.idax.api.client.IdaxApiClientFactory;
import com.idax.api.client.service.IdaxApiRestClient;
import com.idax.api.client.service.IdaxApiWebSocketClient;

/**
 * @program: IdaxConfig
 * @description: IdaxConfig
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 10:55
 */
public class IdaxConfig {

    /**
     * YOUR API KEY
     */
    public static final String API_KEY = "93d6db906e814ab3b0ad5c77aa69ebc2bed4390b1f87444bb040ab775d347858";
    /**
     * YOUR SECRET
     */
    public static final String SECRET = "13896d803ff644d2a0033580b8f86b5abf10d2c9f2d9454da0541e586b6d77d4";

    /**
     * IDAX REST OPEN API BASE URL.
     */
    public static final String API_BASE_URL = "https://qa-openapi.idax.mn";

    /**
     * IDAX WS OPEN API BASE URL.
     */
    public static final String WS_API_BASE_URL = "wss://qa-openws.idax.mn/ws";

    /**
     * init IdaxApiClientFactory
     *
     * @return IdaxApiRestClient
     */
    public static IdaxApiRestClient init() {

        IdaxApiClientFactory factory = IdaxApiClientFactory.newInstance(API_KEY, SECRET, API_BASE_URL);

        return factory.newRestClient();
    }

    /**
     * wsInit  WebSocketClient
     * @return IdaxApiWebSocketClient
     */
    public static IdaxApiWebSocketClient wsInit(){

        IdaxApiClientFactory webSocketClient = IdaxApiClientFactory.newInstance(API_KEY, SECRET, WS_API_BASE_URL);

        return webSocketClient.newWebSocketClient();
    }

}
