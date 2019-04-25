package pro.idax.api.client.service;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
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