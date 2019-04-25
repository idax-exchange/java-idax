package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderHistoryEntry extends BaseEntry {

    /**
     * current page
     */
    private Integer currentPage;
    /**
     * page number
     */
    private Integer pageLength;
    /**
     * total
     */
    private Integer total;
    /**
     * Order List
     */
    private List<Order> orders;

}
