package com.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


/**
 * @program: PairLimitEntry
 * @description: pair limit entry.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PairLimitEntry extends BaseEntry {

    /**
     * Pair Limit
     */
    private List<PairRule> pairRuleVo;

}
