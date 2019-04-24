package com.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: CancelOrderEntry
 * @description: cancel order entry.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CancelOrderEntry extends BaseEntry {

    /**
     * Cancellation of successful orders
     */
    private String accepted;

}
