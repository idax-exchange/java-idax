package pro.idax.api.client.enums;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public enum PeriodEnum {

    /**
     * 1min
     */
    ONE_MINUTE("1min", "1分钟"),
    /**
     * 5min
     */
    FIVE_MINUTE("5min", "5分钟"),
    /**
     * 15min
     */
    FIFTEEN_MINUTE("15min", "15分钟"),
    /**
     * 30min
     */
    THIRTY_MINUTE("30min", "30分钟"),
    /**
     * 1hour
     */
    ONE_HOUR("1hour", "1小时"),
    /**
     * 2hour
     */
    TWO_HOUR("2hour", "2小时"),
    /**
     * 4hour
     */
    FOUR_HOUR("4hour", "4小时"),
    /**
     * 6hour
     */
    SIX_HOUR("6hour", "6小时"),
    /**
     * 12hour
     */
    TWELVE_HOUR("12hour", "12小时"),
    /**
     * 1day
     */
    ONE_DAY("1day", "1天"),
    /**
     * 1week
     */
    ONE_WEEK("1week", "1周");

    /**
     * code
     */
    private String code;
    /**
     * desc
     */
    private String desc;

    /**
     * PeriodEnum
     *
     * @param code code
     * @param desc desc
     */
    PeriodEnum(String code, String desc) {
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
