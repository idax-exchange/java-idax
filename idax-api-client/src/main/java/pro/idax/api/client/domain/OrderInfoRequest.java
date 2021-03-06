package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderInfoRequest implements Serializable {

    private static final long serialVersionUID = -8086954620403215249L;
    /**
     * apikey
     */
    private String key;
    /**
     * symbol in idax
     */
    private String pair;
    /**
     * order no
     */
    private Long orderId;
    /**
     * current page no
     */
    private int pageIndex;
    /**
     * number per page
     */
    private int pageSize;
    /**
     * timestamp expired after 3 minures
     */
    private Long timestamp;
    /**
     * sign
     */
    private String sign;


}
