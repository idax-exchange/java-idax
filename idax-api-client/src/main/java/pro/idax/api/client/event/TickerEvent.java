package pro.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Ticker delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TickerEvent {

  private String open;
  private String high;
  private String low;
  private String last;
  private Long timestamp;
  private String vol;
}
