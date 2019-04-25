package pro.idax.api.client.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@Data
public class KlineRequest implements Serializable {

    private static final long serialVersionUID = -8086954620403215249L;

    /**
     * pair
     */
    private String pair;
    /**
     * period
     */
    private String period;
    /**
     * size
     */
    private Integer size;
    /**
     * since
     */
    private Long since;
}
