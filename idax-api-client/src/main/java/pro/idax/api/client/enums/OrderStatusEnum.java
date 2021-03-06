package pro.idax.api.client.enums;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public enum OrderStatusEnum {
    /**
     * No deal concluded
     */
    NO_DEAL(1, "No deal concluded"),
    /**
     * Partial transaction
     */
    PART_DEAL(2, "Partial transaction"),
    /**
     * Finish
     */
    ALL_DEAL(9, "Finish"),
    /**
     * Withdrawal of documents
     */
    CANCEL(19, "Withdrawal of documents");

    private Integer code;
    private String desc;

    OrderStatusEnum(Integer code, String desc) {
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
