package pro.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 * Trade all delta event .
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TradeAllEventEntry {

  private String code;
  private String channel;
  private List<TradeAllEvent> data;

}
