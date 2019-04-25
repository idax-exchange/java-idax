package pro.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pro.idax.api.client.entry.BaseEntry;

import java.util.List;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MyOrderEntry extends BaseEntry {

  private String code;
  private String channel;
  private List<MyOrderEvent> data;

}
