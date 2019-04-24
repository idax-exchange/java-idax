package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: PairRule
 * @description: PairRule
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PairRule implements Serializable {

    /**
     * Ticker symbol.
     */
    private String pairName;

    /**
     * maxAmount.
     */
    private String maxAmount;

    /**
     * minAmount.
     */
    private String minAmount;

    /**
     * The price small digital.
     */
    private Integer priceDecimalPlace;

    /**
     * Number of decimal places.
     */
    private Integer qtyDecimalPlace;

}
