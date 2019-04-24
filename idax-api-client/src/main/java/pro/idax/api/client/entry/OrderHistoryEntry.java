package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


/**
 * @program: MarketQuotationExample
 * @description: Order history entry.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
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
