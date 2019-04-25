package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
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
