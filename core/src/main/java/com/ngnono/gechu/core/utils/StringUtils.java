package com.ngnono.gechu.core.utils;

/**
 * Created by ngnono on 14-2-13.
 */
public class StringUtils {
    /**
     * 字符串连接
     *
     * @param str0
     * @param str1
     * @return
     */
    public static String concat(String str0, String str1) {
        StringBuilder sb = new StringBuilder(str0).append(str1);

        return sb.toString();
    }

    /**
     * 字符串连接
     * @param params
     * @return
     */
    public static String concat(String... params) {

        StringBuilder sb = new StringBuilder();
        for (String str : params) {
            sb.append(str);
        }

        return sb.toString();
    }
}
