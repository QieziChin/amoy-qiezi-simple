package com.amoy.common.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * String 工具类
 * Author   茄子🍆
 *
 */
public class StringUtils {

    public static boolean isEmpty(String source){
        return source == null || source.trim().isEmpty();
    }

    /**
     * 判断是否为空
     * @param obj source
     * @return 返回是否为空
     */
    public static boolean isEmpty(Object obj){
        if (obj == null ){
            return true;
        } else {
            String str = obj.toString();
            return str.isEmpty();
        }
    }

    public static String replace(String holder, String target, String source){
        return source.replaceAll(holder, target);
    }

    public static String replace(String[] holder, String target, String source){
        for (String meili: holder){
            source = source.replaceAll(meili, target);
        }
        return source;
    }

    public static String join(String[] arrays, String holder){
        return join(arrays, holder, null, false, 0);
    }

    public static String join(String[] arrays, String holder, String pattern){
        return join(arrays, holder, pattern, false, 3);
    }

    public static String join(String[] arrays, String holder, String pattern, Boolean tidy){
        return join(arrays, holder, pattern, tidy, 3);
    }
    /**
     * 数组拼接字符串
     * @param arrays  源数组
     * @param holder  间隔
     * @param pattern 格式
     * @param tidy    是否等长
     * @param length  长度
     * @return 拼接好的字符串
     */
    public static String join(String[] arrays, String holder, String pattern, Boolean tidy, Integer length){
        StringBuilder result = new StringBuilder();
        for (int i =0; i< arrays.length; i++){
            if(i != 0){ result.append(holder);}
            if (isEmpty(pattern)){
                result.append(arrays[i]);
            } else {
                result.append(String.format(pattern, Integer.valueOf(arrays[i])));
            }
        }
        if (tidy){
            for (int i =0; i< (length - arrays.length); i++){
                result.insert(0, String.format("000%s", holder));
            }
        }

        return result.toString();
    }

    /**
     * 字符串数组去重
     * @param holder 源数组
     * @return 去重后的数组
     */
    public static String[] filter(String[] holder){
        return StringUtils.filter(holder, true);
    }

    public static String[] filter(String[] holder, Boolean ignoreCase){
        List<String> result = new ArrayList<>();
        List<String> check = new ArrayList<>();
        for (String meili: holder){
            if (StringUtils.isEmpty(meili)) {continue;}
            if (ignoreCase) {
                if (!check.contains(meili.trim().toLowerCase())){
                    check.add(meili.trim().toLowerCase());
                    result.add(meili.trim());
                }
            } else {
                if (!result.contains(meili.trim())){
                    result.add(meili.trim());
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public static boolean isHttp(String url){
        return url.startsWith("http://") || url.startsWith("https://");
    }

    /**
     * 请用 replace 功能代替
     * @param url Url地址
     * @return 去除协议和域名
     */
    @Deprecated
    public static String nudityDomain(String url){
        String[] holder = {"https://", "https//"};
        url = StringUtils.replace(holder, "", url);
        return url.substring(url.indexOf("/"));
    }

    /**
     * double 格式化
     * @param pattern 格式串 "###,###,###"
     * @param source  源
     * @return 格式化后的字符串
     */
    public static String getFormat(String pattern, double source){
        DecimalFormat simple = new DecimalFormat(pattern);
        return simple.format(source);
    }
}
