package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CancelOrderRequest implements Serializable {

    private static final long serialVersionUID = 3702675428176449908L;

    /**
     * apikey
     */
    private String key;
    /**
     * order no ,seperate in
     */
    private String orderId;
    /**
     * sign
     */
    private String sign;
    /**
     * timestamp expired after 3 minutes
     */
    private Long timestamp;

}
