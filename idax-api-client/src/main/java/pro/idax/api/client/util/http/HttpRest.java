package pro.idax.api.client.util.http;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@Slf4j
public class HttpRest<T> {


    /**
     * post
     *
     * @param url    url
     * @param param  param
     * @param tClass tClass
     * @return T
     */
    public T post(String url, Object param, Class<T> tClass) {
        String result = null;
        try {
            result = HttpClientTools.doPost(url, JSON.toJSONString(param));
            log.info("httpClient request url:" + url + " param:" + JSON.toJSONString(param) + " response:" + result);
        } catch (Exception e) {
            log.info("httpClient exception" + e);
        }
        return JSON.parseObject(result, tClass);
    }

    /**
     * get
     *
     * @param url    url
     * @param tClass tClass
     * @return T
     */
    public T get(String url, Class<T> tClass) {
        String result = null;
        try {
            result = HttpClientTools.doGet(url);
            log.info("httpClient request url:" + url + " response:" + result);
        } catch (Exception e) {
            log.info("httpClient exception" + e);
        }
        return JSON.parseObject(result, tClass);
    }


    /**
     * get
     *
     * @param url url
     * @return T
     */
    public String get(String url) {
        String result = null;
        try {
            result = HttpClientTools.doGet(url);
            log.info("httpClient request url:" + url + " response:" + result);
        } catch (Exception e) {
            log.info("httpClient exception" + e);
        }
        return result;
    }

    /**
     * get
     *
     * @param url    url
     * @param param  param
     * @param tClass tClass
     * @return T
     */
    public T get(String url, Map<String, String> param, Class<T> tClass) {
        String result = null;
        try {
            result = HttpClientTools.doGet(url, param);
            log.info("httpClient request url:" + url + " param:" + JSON.toJSONString(param) + " response:" + result);
        } catch (Exception e) {
            log.info("httpClient exception" + e);
        }
        return JSON.parseObject(result, tClass);
    }
}
