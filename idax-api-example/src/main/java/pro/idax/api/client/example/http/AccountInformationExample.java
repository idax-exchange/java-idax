package pro.idax.api.client.example.http;

import com.alibaba.fastjson.JSON;
import pro.idax.api.client.example.config.IdaxConfig;
import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.domain.UserInfoRequest;
import pro.idax.api.client.entry.UserInfoEntry;
import pro.idax.api.client.service.IdaxApiRestClient;

/**
 * @program: AccountInformationExample
 * @description: Examples of how to obtain user account information
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/26 17:24
 */
@Slf4j
public class AccountInformationExample {


    /**
     * run
     *
     * @param args
     */
    public static void main(String[] args) {

        /**getUserInfo**/
        getUserInfoExample();

    }


    /**
     * getUserInfoExample
     * Get account info
     */
    private static void getUserInfoExample() {

        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.setTimestamp(System.currentTimeMillis());
        userInfoRequest.setKey(IdaxConfig.API_KEY);

        /**Call remote interface**/
        UserInfoEntry userInfoEntry = idaxApiRestClient.getUserInfo(userInfoRequest);

        log.info("getUserInfoExample result:{}", JSON.toJSONString(userInfoEntry));

    }

}
