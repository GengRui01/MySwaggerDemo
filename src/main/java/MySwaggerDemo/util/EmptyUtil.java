package MySwaggerDemo.util;

import java.util.Collection;

/**
 * Description: 判空工具类
 *
 * @ClassName: EmptyUtil
 * @Author: GengRui
 * @Date: 2019/11/25 16:17
 */
public class EmptyUtil {

    /**
     * Description: 判断StringBuilder是否为空，长度为0被认为是空的StringBuilder.
     *
     * @param stringBuilder
     * @return
     */
    public static boolean isEmpty(StringBuilder stringBuilder) {
        if (null != stringBuilder) {
            return stringBuilder.length() == 0;
        } else {
            return true;
        }
    }

    /**
     * Description: 判断字符串是否为空，长度为0被认为是空字符串.
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (null != str) {
            return str.trim().length() == 0;
        } else {
            return true;
        }
    }

    /**
     * Description: 判断列表是否为空，列表没有元素也被认为是空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }

    /**
     * Description: 判断数组是否为空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return null == array || array.length == 0;
    }

    /**
     * Description: 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}
