package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pro.idax.api.client.enums.OrderSideEnum;
import pro.idax.api.client.enums.OrderTypeEnum;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PlaceOrderRequest implements Serializable {

    private static final long serialVersionUID = 5729580002076831387L;
    /**
     * key
     */
    private String key;
    /**
     * symbol in idax
     */
    private String pair;
    /**
     * order type {@link OrderTypeEnum}
     */
    private String orderType;
    /**
     * order side {@link OrderSideEnum}
     */
    private String orderSide;
    /**
     * order price
     */
    private BigDecimal price;
    /**
     * order number
     */
    private BigDecimal amount;
    /**
     * sign
     */
    private String sign;
    /**
     * timestamp expired after 3 minutes
     */
    private Long timestamp;

}
