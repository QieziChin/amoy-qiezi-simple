package com.amoy.common.utils;

/**
 * String 工具类
 * @Auth 茄子🍆
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    /**
     * 判断是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if (obj == null ){
            return true;
        } else {
            String str = obj.toString();
            return str.length() == 0;
        }
    }

    public static String replace(String[] holder, String target,  String source){
        for (String meili: holder){
            source = source.replaceAll(meili, target);
        }
        return source;
    }

    public static boolean isHttp(String url){
        return url.startsWith("http://") || url.startsWith("https://");
    }

    public static String nudityDomain(String url){
        String[] holder = {"https://", "https//"};
        url = StringUtils.replace(holder, "", url);
        return url.substring(url.indexOf("/"));
    }
}
