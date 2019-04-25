package pro.idax.api.client.enums;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public enum OrderSideEnum {

    /**
     * buy
     */
    BUY("buy", "买"),
    /**
     * sell
     */
    SELL("sell", "卖");

    private String code;
    private String desc;

    OrderSideEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
