package com.amoy.common.utils;

import org.springframework.stereotype.Component;

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
}
