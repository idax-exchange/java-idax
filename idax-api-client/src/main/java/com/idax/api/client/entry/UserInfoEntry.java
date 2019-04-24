package com.idax.api.client.entry;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @program: UserInfoEntry
 * @description: UserInfoEntry
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:28
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserInfoEntry extends BaseEntry {

    /**
     * total ->total asset
     **/
    private JSONObject total;
    /**
     * free->available asset
     */
    private JSONObject free;
    /**
     * freezed-> freeze asset
     */
    private JSONObject freezed;

}
