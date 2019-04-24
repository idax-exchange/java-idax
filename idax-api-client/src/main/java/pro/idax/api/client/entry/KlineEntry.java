package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


/**
 * @program: KlineEntry
 * @description: kline entry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class KlineEntry extends BaseEntry {

    /**
     * kline List
     */
    private List<String> kline;

}
