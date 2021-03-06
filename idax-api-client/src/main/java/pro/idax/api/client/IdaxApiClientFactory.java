package pro.idax.api.client;


import pro.idax.api.client.service.IdaxApiRestClient;
import pro.idax.api.client.service.IdaxApiWebSocketClient;
import pro.idax.api.client.service.impl.IdaxApiRestClientImpl;
import pro.idax.api.client.service.impl.IdaxApiServiceGenerator;
import pro.idax.api.client.service.impl.IdaxApiWebSocketClientImpl;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public class IdaxApiClientFactory {

    private static volatile IdaxApiClientFactory idaxApiClientFactoryInstance;

    private static volatile IdaxApiWebSocketClient idaxApiWebSocketClient;

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
     * Instantiates a new Idax api client factory.
     * @param apiKey apiKey
     * @param secret secret
     * @param apiBaseUrl apiBaseUrl
     */
    private IdaxApiClientFactory(String apiKey, String secret, String apiBaseUrl) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.apiBaseUrl = apiBaseUrl;
    }

    /**
     * New instance
     * @param apiKey apiKey
     * @param secret secret
     * @param apiBaseUrl apiBaseUrl
     * @return IdaxApiClientFactory
     */
    public static IdaxApiClientFactory newInstance(String apiKey, String secret, String apiBaseUrl) {

        if (idaxApiClientFactoryInstance == null) {
            synchronized (IdaxApiClientFactory.class) {
                if (idaxApiClientFactoryInstance == null) {
                    idaxApiClientFactoryInstance = new IdaxApiClientFactory(apiKey, secret, apiBaseUrl);
                }
            }
        }

        return idaxApiClientFactoryInstance;
    }

    /**
     * New instance without authentication.
     *
     * @return the Idax api client factory
     */
    public static IdaxApiClientFactory newInstance() {

        if (idaxApiClientFactoryInstance == null) {
            synchronized (IdaxApiClientFactory.class) {
                if (idaxApiClientFactoryInstance == null) {
                    idaxApiClientFactoryInstance = new IdaxApiClientFactory(null, null, null);
                }
            }
        }

        return idaxApiClientFactoryInstance;
    }

    /**
     * Creates a new synchronous/blocking REST client.
     * @return IdaxApiRestClient
     */
    public IdaxApiRestClient newRestClient() {

        return new IdaxApiRestClientImpl(apiKey, secret, apiBaseUrl);
    }

    /**
     * newWebSocketClient
     *
     * @return IdaxApiWebSocketClient
     */
    public IdaxApiWebSocketClient newWebSocketClient() {

        if (idaxApiWebSocketClient == null) {
            synchronized (IdaxApiClientFactory.class) {
                if (idaxApiWebSocketClient == null) {
                    idaxApiWebSocketClient = new IdaxApiWebSocketClientImpl(IdaxApiServiceGenerator.getSharedClient(), apiKey, secret, apiBaseUrl);
                }
            }
        }
        return idaxApiWebSocketClient;
    }

}
