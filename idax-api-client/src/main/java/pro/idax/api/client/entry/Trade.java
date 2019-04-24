package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.Serializable;


/**
 * @program: Trade
 * @description: Trade
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
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
