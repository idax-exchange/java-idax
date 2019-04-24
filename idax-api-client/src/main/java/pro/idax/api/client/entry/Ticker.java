package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: Ticker
 * @description: 24 hour price change statistics for a ticker.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Ticker implements Serializable {

    /**
     * Ticker pair.
     */
    private String pair;

    /**
     * Open price 24 hours ago.
     */
    private String open;

    /**
     * Highest price during the past 24 hours.
     */
    private String high;

    /**
     * Lowest price during the past 24 hours.
     */
    private String low;

    /**
     * lastst price during the past 24 hours.
     */
    private String last;

    /**
     * Total volume during the past 24 hours.
     */
    private String vol;

}
