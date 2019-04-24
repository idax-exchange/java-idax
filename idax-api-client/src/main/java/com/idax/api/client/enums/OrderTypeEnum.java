package com.idax.api.client.enums;

/**
 * @program: OrderTypeEnum
 * @description: OrderTypeEnum
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/01 17:28
 */
public enum OrderTypeEnum {
    /**
     * limit
     */
    LIMIT("limit", "限价"),
    /**
     * market
     */
    MARKET("market", "市价");

    private String code;
    private String desc;

    OrderTypeEnum(String code, String desc) {
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
