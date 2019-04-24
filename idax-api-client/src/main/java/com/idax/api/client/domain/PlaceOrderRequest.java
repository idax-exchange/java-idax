package com.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: PlaceOrderRequest
 * @description: place order request
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PlaceOrderRequest implements Serializable {

    private static final long serialVersionUID = 5729580002076831387L;
    /**
     * key
     */
    private String key;
    /**
     * symbol in idax
     */
    private String pair;
    /**
     * order type {@link com.idax.api.client.enums.OrderTypeEnum}
     */
    private String orderType;
    /**
     * order side {@link com.idax.api.client.enums.OrderSideEnum}
     */
    private String orderSide;
    /**
     * order price
     */
    private BigDecimal price;
    /**
     * order number
     */
    private BigDecimal amount;
    /**
     * sign
     */
    private String sign;
    /**
     * timestamp expired after 3 minutes
     */
    private Long timestamp;

}
