package pro.idax.api.client.entry;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserInfoEntry extends BaseEntry {

    /**
     * total asset
     **/
    private JSONObject total;
    /**
     * available asset
     */
    private JSONObject free;
    /**
     * freeze asset
     */
    private JSONObject freezed;

}
