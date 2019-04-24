package com.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: MarketQuotationExample
 * @description: Order place response entry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PlaceOrderEntry extends BaseEntry {


    /**
     * order no
     */
    private String orderId;

}
