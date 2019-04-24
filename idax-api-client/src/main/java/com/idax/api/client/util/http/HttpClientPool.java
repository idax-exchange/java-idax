package com.idax.api.client.util.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.annotation.PostConstruct;
/**
 * @program: HttpClientPool
 * @description: HttpClientPool
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
public class HttpClientPool {


    private static PoolingHttpClientConnectionManager cm = null;


    static {
        cm = new PoolingHttpClientConnectionManager();
        // 总连接数
        cm.setMaxTotal(5);
        // 同路由的并发数
        cm.setDefaultMaxPerRoute(10);
    }


    public static CloseableHttpClient getHttpClient(){
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();
        return client;
    }
}
