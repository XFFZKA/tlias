package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 使用更安全的密钥（至少256位/32字节）
    private static final String signKey = "itheimaitheimaitheimaitheima1234"; // 32字符
    private static final SecretKey key = Keys.hmacShaKeyFor(signKey.getBytes(StandardCharsets.UTF_8));
    private static final Long expire = 43200000L; // 12小时

//    /​**​
//            * 生成JWT令牌
//     * @param claims JWT第二部分负载 payload 中存储的内容
//     * @return
//             */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims) // 新版API使用claims()而不是addClaims()
                .expiration(new Date(System.currentTimeMillis() + expire))
                .signWith(key) // 使用安全的SecretKey对象
                .compact();
    }

//    /​**​
//            * 解析JWT令牌
//     * @param jwt JWT令牌
//     * @return JWT第二部分负载 payload 中存储的内容
//     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .verifyWith(key) // 新版API使用verifyWith()
                .build()
                .parseSignedClaims(jwt) // 新版API方法名
                .getPayload();
    }
}