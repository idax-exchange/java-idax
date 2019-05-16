package pro.idax.api.client.util.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import pro.idax.api.client.constant.IdaxApiConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public class HttpClientTools {


    /**
     * doPost
     * Handling body post requests in JSON format
     * @param url url
     * @param jsonObj jsonObj
     * @return String
     * @throws ClientProtocolException ClientProtocolException
     * @throws Exception Exception
     */
    public static String doPost(String url, String jsonObj) throws ClientProtocolException, Exception {

        HttpPost post = new HttpPost(url);
        post.setHeader(IdaxApiConstants.CONTENT_TYPE, IdaxApiConstants.APPLICATION_JSON);
        post.addHeader(IdaxApiConstants.CONNECTION, IdaxApiConstants.KEEP_ALIVE);
        String str = null;
        StringEntity s = new StringEntity(jsonObj, "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, IdaxApiConstants.APPLICATION_JSON));
        post.setEntity(s);

        CloseableHttpResponse response = HttpClientPool.getHttpClient().execute(post);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            str = convertStreamToString(instreams);
            post.abort();
        }
        response.close();

        return str;
    }


    /**
     * doGet
     * Handling HTTP get requests
     * @param url url
     * @return String
     * @throws ClientProtocolException ClientProtocolException
     * @throws Exception Exception
     */
    public static String doGet(String url) throws ClientProtocolException, Exception {

        HttpGet get = new HttpGet(url);
        get.setHeader(IdaxApiConstants.CONTENT_TYPE, IdaxApiConstants.APPLICATION_JSON);
        get.addHeader(IdaxApiConstants.CONNECTION, IdaxApiConstants.KEEP_ALIVE);
        String str = null;

        CloseableHttpResponse response = HttpClientPool.getHttpClient().execute(get);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            str = convertStreamToString(instreams);
            get.abort();
        }
        response.close();

        return str;
    }

    /**
     *doGet
     * Handling HTTP get requests
     * @param url url
     * @param paramsMap paramsMap
     * @return String
     * @throws ClientProtocolException ClientProtocolException
     * @throws Exception Exception
     */
    public static String doGet(String url, Map paramsMap) throws ClientProtocolException, Exception {

        String getUrlAndParam = setGetParams(url,paramsMap);
        HttpGet get = new HttpGet(getUrlAndParam);
        get.addHeader(IdaxApiConstants.CONNECTION, IdaxApiConstants.KEEP_ALIVE);
        String str = null;
        CloseableHttpResponse response = HttpClientPool.getHttpClient().execute(get);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream inStreams = entity.getContent();
            str = convertStreamToString(inStreams);
            get.abort();
        }
        response.close();

        return str;
    }

   /**setGetParams
     * Get request, only key-value pair parameters
     * @param url url
     * @param paramsMap paramsMap
     * @return String
     */
    public static String  setGetParams(String url, Map paramsMap) {
        StringBuilder stringBuilderUrl = new StringBuilder(url);
        if(paramsMap != null){
            stringBuilderUrl.append("?");
            for (Object key: paramsMap.keySet()){
                stringBuilderUrl.append(key + "=" + paramsMap.get(key) + "&");
            }
            return stringBuilderUrl.substring(0, stringBuilderUrl.length() - 1);
        }
        return stringBuilderUrl.toString();
    }


    /**
     * convertStreamToString
     * @param is is
     * @return String
     */
    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
