package pro.idax.api.client.enums;

/**
 * @program: DepthYEnum
 * @description: DepthYEnum
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/04 17:28
 */
public enum DepthYEnum {

    /**
     * FIVE
     */
    FIVE(5,"5"),
    TEN(10,"10"),
    TWENTY(20,"20"),
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
     * @param code
     * @param desc
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
