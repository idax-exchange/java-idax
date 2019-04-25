package pro.idax.api.client.util;

import pro.idax.api.client.constant.IdaxApiConstants;

import java.util.Map;
import java.util.TreeMap;


/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
public class ObjectUtils {

    /**
     * sortMap
     *
     * @param paramMap paramMap
     * @return String
     */
    public static String sortMap(Map<String, Object> paramMap) {

        TreeMap<String, Object> treeMap = new TreeMap(paramMap);

        StringBuffer strBuffer = new StringBuffer();

        for (String key : treeMap.keySet()) {

            strBuffer.append(key).append(IdaxApiConstants.BE_EQUAL_TO).append(paramMap.get(key)).append(IdaxApiConstants.ALSO);

        }
        strBuffer.deleteCharAt(strBuffer.length() - 1);

        return strBuffer.toString();
    }

}
