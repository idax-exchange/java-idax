package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderListRequest implements Serializable {

    private static final long serialVersionUID = -3816218171205025634L;
    /**
     * apikey
     */
    private String key;
    /**
     * symbol in idax
     */
    private String pair;
    /**
     * order no  seperate use comma
     */
    private String orderId;
    /**
     * sign
     */
    private String sign;
    /**
     * timestamp expired after 3 minures
     */
    private Long timestamp;

}
