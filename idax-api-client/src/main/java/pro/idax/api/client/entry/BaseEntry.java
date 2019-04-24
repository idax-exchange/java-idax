package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.io.Serializable;

/**
 * @program: BaseEntry
 * @description: BaseEntry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BaseEntry implements Serializable {
    
    private static final long serialVersionUID = -5689198338173955964L;
    /**
     * code
     */
    private String code;
    /**
     * message
     */
    private String msg;
    /**
     * timestamp
     */
    private Long timestamp;
}
