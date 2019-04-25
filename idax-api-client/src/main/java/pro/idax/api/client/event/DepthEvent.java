package pro.idax.api.client.event;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DepthEvent {

  private String channel;
  private JSONArray data;
}
