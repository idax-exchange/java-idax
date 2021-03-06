package pro.idax.api.client.enums;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public enum EventKeyEnum {

    /**
     * depthX
     */
    DEPTH_X("depthX", "idax_sub_#{symbol}_depth"),
    DEPTH_XY("depthXY", "idax_sub_#{symbol}_depth_#{number}"),
    TICKER("ticker", "idax_sub_#{symbol}_ticker"),
    KLINE("kline", "idax_sub_#{symbol}_kline_#{period}"),
    TRADE("trade", "idax_sub_#{symbol}_trades"),
    MY_TRADE("mytrade", "idax_sub_mytrade"),
    MY_ORDER("myorder", "idax_sub_myorder");

    /**
     * code
     */
    private String code;
    /**
     * desc
     */
    private String desc;

    /**
     * EventKeyEnum
     *
     * @param code code
     * @param desc desc
     */
    EventKeyEnum(String code, String desc) {
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
