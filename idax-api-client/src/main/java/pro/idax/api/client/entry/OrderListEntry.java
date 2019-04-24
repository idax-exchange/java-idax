package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @program: OrderListEntry
 * @description: Order list response entry.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderListEntry extends BaseEntry {

    /**
     * Order List
     */
    private List<Order> orders;

}
