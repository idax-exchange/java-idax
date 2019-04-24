package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: Order
 * @description: Order
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 5011656963716693083L;

    /**
     * delegate number.
     */
    private String quantity;

    /**
     * average price.
     */
    private String avgPrice;
    /**
     * delegate time
     */
    private Long timestamp;
    /**
     * deal number
     */
    private String dealQuantity;
    /**
     * order no
     */
    private Long orderId;
    /**
     * delegate price
     */
    private String price;
    /**
     * delegate status 1:No deal 2:Partial deal 9:Complete deal 19:Withdrawal
     */
    private String orderState;
    /**
     * order side 1:buy/2:sell
     */
    private String orderSide;

}
