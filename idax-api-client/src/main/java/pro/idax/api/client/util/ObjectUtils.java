package pro.idax.api.client.util;

import pro.idax.api.client.constant.IdaxApiConstants;

import java.util.Map;
import java.util.TreeMap;


/**
 * @program: ObjectUtils
 * @description: ObjectUtils
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
public class ObjectUtils {

    /**
     * sortMap
     *
     * @param paramMap
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
