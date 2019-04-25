package pro.idax.api.client.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
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
