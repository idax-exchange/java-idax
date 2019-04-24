package com.idax.api.client.entry;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.idax.api.client.constant.IdaxApiConstants;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


/**
 * @program: MarketQuotationExample
 * @description: Order book of a symbol in Idax.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderBookEntry extends BaseEntry{


  /**
   * List of bids (price/qty).
   */
  private JSONArray bids;

  /**
   * List of asks (price/qty).
   */
  private JSONArray asks;

}
