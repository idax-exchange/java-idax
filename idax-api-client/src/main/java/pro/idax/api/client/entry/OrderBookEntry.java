package pro.idax.api.client.entry;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderBookEntry extends BaseEntry{


  /**
   * List of bids (price/qty).
   */
  private JSONArray bids;

  /**
   * List of asks (price/qty).
   */
  private JSONArray asks;

}
