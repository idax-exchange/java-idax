package com.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;


/**
 * @program: TradeEntry
 * @description: Trade Entry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TradeEntry extends BaseEntry {

    /**
     * Trade List
     */
    private List<Trade> trades;

}
