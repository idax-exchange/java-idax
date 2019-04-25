package pro.idax.api.client.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@Data
public class MyTradesEntry implements Serializable {

    private Long timestamp;
    /**
     * order price
     */
    private String price;
    /**
     * order quantity
     */
    private String quantity;
    /**
     * pair
     */
    private String pair;
    /**
     * buy/sell
     */
    private String maker;

}
