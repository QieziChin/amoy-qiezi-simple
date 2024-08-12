package com.amoy.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String KEY = "cb02fef92bac";

    private static long expire = 60 * 60 * 24;

    public static String getToken(Map<String, Object> claims){
        Date expireDate = new Date(System.currentTimeMillis() + expire * 1000);

        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String, Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

    public static long getExpire() {
        return expire;
    }
}
