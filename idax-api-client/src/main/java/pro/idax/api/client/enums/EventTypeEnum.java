package pro.idax.api.client.enums;

/**
 * @program: EventTypeEnum
 * @description: EventTypeEnum
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/04 17:28
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
     * @param code
     * @param desc
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
