package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Trade implements Serializable {

    private Long timestamp;
    /**
     * deal price
     */
    private String price;
    /**
     * deal no
     */
    private String id;
    /**
     * deal number
     */
    private String quantity;
    /**
     * deal type(buy or sell)
     */
    private String maker;

}
