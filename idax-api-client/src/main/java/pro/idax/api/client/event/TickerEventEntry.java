package pro.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 * Ticker delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TickerEventEntry {

  private String channel;
  private List<TickerEvent> data;

}
