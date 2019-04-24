package com.idax.api.client.event;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Trade all delta event .
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TradeAllEventEntry {

  private String code;
  private String channel;
  private List<TradeAllEvent> data;

}
