package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserInfoRequest implements Serializable {

    private static final long serialVersionUID = 625153856963537856L;
    /**
     * key
     */
    private String key;
    /**
     * sign
     */
    private String sign;
    /**
     * timestamp
     */
    private Long timestamp;

}
