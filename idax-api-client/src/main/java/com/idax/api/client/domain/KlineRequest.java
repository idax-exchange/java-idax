package com.idax.api.client.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: KLineRequest
 * @description: KLineRequest
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@Data
public class KlineRequest implements Serializable {

    private static final long serialVersionUID = -8086954620403215249L;

    /**
     * pair
     */
    private String pair;
    /**
     * period
     */
    private String period;
    /**
     * size
     */
    private Integer size;
    /**
     * since
     */
    private Long since;
}
