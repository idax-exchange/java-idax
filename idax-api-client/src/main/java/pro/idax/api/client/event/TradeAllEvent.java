package pro.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Order or trade report update event.
 *
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TradeAllEvent {

  @JsonProperty("e")
  private String eventType;

  @JsonProperty("E")
  private Long eventTime;

  @JsonProperty("s")
  private String symbol;

  /**
   * Trade id.
   */
  @JsonProperty("t")
  private Long tradeId;

  /**
   * Price.
   */
  @JsonProperty("p")
  private String price;

  /**
   * Original quantity in the order.
   */
  @JsonProperty("q")
  private String quantity;

  /**
   * bid order id .
   */
  @JsonProperty("b")
  private Long bidOrderId;

  @JsonProperty("a")
  private Long askOrderId;

  @JsonProperty("as")
  private Integer askOrderStatus;

  @JsonProperty("bs")
  private Integer bidOrderStatus;

  @JsonProperty("T")
  private Long tradeTime;

  @JsonProperty("B")
  private Integer buyAccountId;

  @JsonProperty("S")
  private Integer sellAccountId;

  /**
   * flag of market maker (true: market maker)
   */
  @JsonProperty("m")
  private Boolean flag;

}
