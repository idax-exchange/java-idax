package com.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


/**
 * @program: TickerEntry
 * @description: 24 hour price change statistics for a ticker.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TickerEntry extends BaseEntry {

    /**
     * Ticker List
     */
    private List<Ticker> ticker;


}
