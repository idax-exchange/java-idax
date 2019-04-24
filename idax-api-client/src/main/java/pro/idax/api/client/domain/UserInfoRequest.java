package pro.idax.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: UserInfoRequest
 * @description: User Info Request
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
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
