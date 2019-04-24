package com.idax.api.client.event;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * batch register delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BatchRegisterEventEntry {

  private JSONArray data;
}
