package pro.idax.api.client.enums;

/**
 * @program: IdaxCodeEnum
 * @description: IdaxCodeEnum
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/01 17:28
 */
public enum IdaxCodeEnum {

    /**
     * Successful request processing
     */
    SUCCESS(10000, "Successful request processing"),
    /**
     * System exception/server busy
     */
    SYSTEM_ERROR(10001, "System exception/server busy"),
    PARAM_MISSING(10002, "Parameters can not be empty"),
    PARAM_INVALID(10003, "Illegal parameter"),
    NOT_SUPPORT_SYMBOL(10004, "Not supported pair"),
    NOT_SUPPORT_TRADE(10005, "The transaction is not supported"),
    ORDER_STATUS_EXCEPTION(10006, "order state is error"),
    UNBIND_USER(10007, "No account information"),
    SECRET_KEY_NOT_EXIST(10008, "key does not exist"),
    PARAM_TIMESTAMP_MISSING(10009, "Timestamp is empty"),
    EXPIRED_TIMESTAMP(10010, "Timestamp Expirated"),
    PARAM_SIGN_MISSING(10011, "Sign is empty"),
    IP_NOTIN_WHITE(10012, "Ip is not on the white list of requests"),
    SIGN_NOT_MATCH(10013, "Signature mismatch"),
    ORDER_FAIL(10014, "Place Order failed"),
    CANCEL_ORDER_FAIL(10015, "Cancel Order failed"),
    REQUEST_FREQUENTLY(10016, "The request interface is too frequent. Please try again later"),
    SYMBOL_NOT_SUPPORT(10017, "Exchanges do not support trading pair"),
    COIN_PRICE_IS_EMPTY(10018, "Currency price is empty"),
    CANCEL_MORE_THAN(10019, "A maximum of 5 orders can be revoked at a time"),
    ORDER_NO_EMTYP(10020, "orderId is empty"),
    PRICE_INVALID(101001, "secret is empty"),
    NUM_INVALID(101002, "Unlawful price input"),
    INSTRUCT_INVALID(101003, "Unlawful quantity input"),
    SYMBOL_INVALID(101004, "Coin Pair UnKnown"),
    TRANS_PRICE_INVALID(101005, "Trade CreateOrder Price Decimal Place Error"),
    TRANS_NUM_DECIMAL_INVALID(101006, "Trade CreateOrder Qty Decimal Place Error"),
    TRANS_MORE_THAN_MAX(101007, "Trade Amount Max"),
    TRANS_MORE_THAN_MIN(101008, "Trade Amount Min"),
    ACCOUNT_MONEY_NOT_ENOUGH(101009, "Insufficient account balance"),
    AVAILABLE_IS_NOT_ENOUGH(101010, "Available Amount Not Enough"),
    ORDER_NO_ALREAD(101011, "OrderId NotExist"),
    CANCEL_ORDER_ERROR(101012, "cancel Order Fail"),
    SELECT_RATE_FAIL(101013, "Query Floating Rate Fail"),
    BUY_PRICE_FAIL(101014, "Buy Price Fail"),
    SELL_PRICE_FAIL(101015, "Sell Price Fail"),
    CREATE_ORDER_SERVEING(101016, "Create order maintenance"),
    SELECT_DATA_EMPTY(101017, "Query Setting Empty"),
    PRICE_EMPTY(101018, "Price input is empty"),
    NUM_EMPTY(101019, "Amount input is empty"),
    ORDER_DEALED(101020, "the order is finished"),
    ORDER_CANCELD(101021, "the order is cancel"),
    SYMBOL_NOT_SELL(101022, "Trade is not allowed to be traded on no shelf"),
    ORDER_INVALID(101023, "This order is invalid"),
    NOT_SUPPORT(10999, "According to the relevant laws, you can not use this function in your country or region"),
    INTERFACE_PARAM_MISSING(11000, "Parameter missing, please verify your parameters");

    /**
     * code
     */
    private Integer code;
    /**
     * desc
     */
    private String desc;

    /**
     * IdaxCodeEnum
     * @param code
     * @param desc
     */
    IdaxCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
