package pro.idax.api.client.enums;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public enum EventTypeEnum {

    /**
     * addChannel
     */
    ADD_CHANNEL("addChannel", "addChannel"),
    /**
     * updateChannel
     */
    UPDATE_CHANNEL("updateChannel", "updateChannel");

    private String code;
    private String desc;

    /**
     * EventTypeEnum
     * @param code code
     * @param desc desc
     */
    EventTypeEnum(String code, String desc) {
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
