package com.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: TradeHistoryRequest
 * @description: Trade History Request
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TradeHistoryRequest implements Serializable {

    private static final long serialVersionUID = -8086954620403215249L;

    /**
     * apikey
     * required
     */
    private String key;
    /**
     * symbol
     * required
     */
    private String pair;
    /**
     * deal id
     * not required
     */
    private Long since;
    /**
     * is valid int 3minute
     * required
     */
    private Long timestamp;
    /**
     * sign
     * required
     */
    private String sign;

}
