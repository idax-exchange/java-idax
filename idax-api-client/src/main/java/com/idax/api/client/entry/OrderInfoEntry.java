package com.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @program: OrderInfoEntry
 * @description: OrderInfoEntry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderInfoEntry extends BaseEntry {
    /**
     * total
     */
    private int total;
    /**
     * Order List
     */
    private List<Order> orders;

}
