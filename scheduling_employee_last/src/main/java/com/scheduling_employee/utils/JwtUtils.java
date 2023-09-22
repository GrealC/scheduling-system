package com.scheduling_employee.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "itheima";
    // 过期时间 毫秒
    private static Long expire = 433200000L;

    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        JwtUtils.userId = userId;
    }

    //    生成令牌
    public static String generateJwt(Map<String,Object> claims){
        String jwt= Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();

        return jwt;
    }

    //解析令牌
    public static Claims parseJWT(String jwt){
        Claims claims=Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
