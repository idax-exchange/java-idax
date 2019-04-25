package pro.idax.api.client.exception;


/**
 * IdaxApiException
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public class IdaxApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Idax API.
     */
    private IdaxApiError error;

    /**
     * Instantiates a new Idax api exception.
     *
     * @param error an error response object
     */
    public IdaxApiException(IdaxApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new Idax api exception.
     */
    public IdaxApiException() {
        super();
    }

    /**
     * Instantiates a new Idax api exception.
     *
     * @param message the message
     */
    public IdaxApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Idax api exception.
     *
     * @param cause the cause
     */
    public IdaxApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Idax api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public IdaxApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Idax API, or null if no response object was returned (e.g. server returned 500).
     */
    public IdaxApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }

}
