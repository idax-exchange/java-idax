package pro.idax.api.client.util;

import lombok.extern.slf4j.Slf4j;
import pro.idax.api.client.constant.IdaxApiConstants;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhuWei (ynzhuwei888@126.com)
 */
@Slf4j
public class BeanUtil {


    /**
     * transBean2Map
     *
     * @param obj obj
     * @return Map
     */
    public static Map<String, Object> transBean2Map(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>(1000);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!IdaxApiConstants.CLASS.equals(key)) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            log.error("transBean2Map Error :" + e);
        }
        return map;

    }

    /**
     * transBean2MapString
     *
     * @param obj obj
     * @return Map
     */
    public static Map<String, String> transBean2MapString(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>(1000);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!IdaxApiConstants.CLASS.equals(key)) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (value != null && !"".equals(String.valueOf(obj))) {
                        map.put(key, String.valueOf(value));
                    }
                }

            }
        } catch (Exception e) {
            log.error("transBean2Map Error :" + e);
        }
        return map;

    }
}
