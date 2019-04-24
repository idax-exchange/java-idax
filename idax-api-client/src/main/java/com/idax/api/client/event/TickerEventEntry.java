package com.idax.api.client.event;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Ticker delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TickerEventEntry {

  private String channel;
  private List<TickerEvent> data;

}
