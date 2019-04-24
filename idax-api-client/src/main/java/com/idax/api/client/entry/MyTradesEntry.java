package com.idax.api.client.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: MyTradesEntry
 * @description: MyTradesEntry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@Data
public class MyTradesEntry implements Serializable {

    private Long timestamp;
    /**
     * order price
     */
    private String price;
    /**
     * order quantity
     */
    private String quantity;
    /**
     * pair
     */
    private String pair;
    /**
     * buy/sell
     */
    private String maker;

}
