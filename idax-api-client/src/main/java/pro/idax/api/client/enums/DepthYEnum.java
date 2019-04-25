package pro.idax.api.client.enums;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public enum DepthYEnum {

    /**
     * 5
     */
    FIVE(5,"5"),
    /**
     * 10
     */
    TEN(10,"10"),
    /**
     * 20
     */
    TWENTY(20,"20"),
    /**
     * 50
     */
    FIFTY(50,"50");

    /**
     * code
     */
    private Integer code;
    /**
     * desc
     */
    private String desc;

    /**
     * DepthYEnum
     * @param code code
     * @param desc desc
     */
    DepthYEnum(Integer code, String desc) {
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
