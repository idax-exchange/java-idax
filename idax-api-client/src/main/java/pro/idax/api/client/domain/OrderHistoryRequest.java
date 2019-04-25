package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderHistoryRequest implements Serializable {

    private static final long serialVersionUID = -8086954620403215249L;

    /**
     * apikey
     * required
     */
    private String key;
    /**
     * symbol
     * required
     */
    private String pair;
    /**
     * order status -1:all, 0：unfinish, 1：finish
     * required
     */
    private Integer orderState;
    /**
     * current page
     * required
     */
    private Integer currentPage;
    /**
     * number of page
     * required
     */
    private Integer pageLength;
    /**
     * is valid int 3minute
     * required
     */
    private Long timestamp;
    /**
     * sign
     * required
     */
    private String sign;


}
