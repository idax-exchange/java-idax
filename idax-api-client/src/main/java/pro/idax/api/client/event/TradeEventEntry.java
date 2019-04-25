package pro.idax.api.client.event;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 * Trade delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TradeEventEntry {

  private String channel;
  private JSONArray data;
}
