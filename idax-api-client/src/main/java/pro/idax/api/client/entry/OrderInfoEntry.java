package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderInfoEntry extends BaseEntry {
    /**
     * total
     */
    private int total;
    /**
     * Order List
     */
    private List<Order> orders;

}
