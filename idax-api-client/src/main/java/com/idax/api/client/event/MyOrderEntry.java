package com.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.idax.api.client.entry.BaseEntry;
import lombok.Data;

import java.util.List;

/**
 * @program: MyOrderEntry
 * @description: MyOrderEntry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/03/4 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MyOrderEntry extends BaseEntry {

  private String code;
  private String channel;
  private List<MyOrderEvent> data;

}
