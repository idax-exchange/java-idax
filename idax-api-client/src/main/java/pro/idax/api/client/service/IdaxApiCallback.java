package pro.idax.api.client.service;

/**
 * @program: IdaxApiCallback
 * @description: IdaxApiCallback is a functional interface used together with the IdaxApiAsyncClient to provide a non-blocking REST client.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/4 17:10
 */
@FunctionalInterface
public interface IdaxApiCallback<T> {

    /**
     * Called whenever a response comes back from the Idax API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {
    }
}