package pro.idax.api.client.event;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@Data
public class SendMessage implements Serializable {

    private String event;
    private String channel;
    private Map<String,Object> parameters;

}
