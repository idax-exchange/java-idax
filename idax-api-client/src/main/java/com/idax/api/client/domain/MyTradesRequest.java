package com.idax.api.client.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: MyTradesRequest
 * @description: MyTradesRequest
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@Data
public class MyTradesRequest implements Serializable {

    private static final long serialVersionUID = -8086954620403215249L;

    /**
     * IDAX supports trade pairs
     */
    private String pair;
    /**
     * buy，sell
     */
    private String orderSide;
    /**
     * current page number
     */
    private Integer currentPage;
    /**
     * number of trade returned per page, maximum 1000
     */
    private Integer pageLength;
    /**
     * start date and timestamp (Millisecond)
     */
    private Long startDate;
    /**
     * end date and timestamp (Millisecond)
     */
    private Long endDate;
    /**
     * apiKey of the user
     */
    private String key;
    /**
     * signature of request parameters
     */
    private String sign;
    /**
     * request timestamp (valid for 3 minutes)
     */
    private Long timestamp;
}
