package com.idax.api.client.event;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.idax.api.client.entry.BaseEntry;
import lombok.Data;

/**
 * @program: KlineEventEntry
 * @description: 24 hour price change statistics for a ticker.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/4 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class KlineEventEntry extends BaseEntry {

  private String code;
  private String channel;
  private JSONArray data;

}
