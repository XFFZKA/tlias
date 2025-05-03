package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

//    @Test
//    void contextLoads() {
//
//    }
//
//    @Test
//    public void testGenJWT1(){
//        Map<String, Object> m = new HashMap<>();
//        m.put("id",1);
//        m.put("username","test");
//        String jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "secret")
//                .setClaims(m)
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600))
//                .compact();
//        System.out.println(jwt);
//    }
//
//    @Test
//    public void testGenJWT() {
//        // 1. 准备密钥（Base64解码）
//        String base64Key = "dGhpcyBpcyBhIHNlY3VyZSBrZXkgZm9yIEpXVCAyNTYgYml0cw==";
//        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
//        SecretKey key = new SecretKeySpec(keyBytes, "HmacSHA256");
//
//        // 2. 设置JWT Claims
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id", 1);
//        claims.put("username", "test");
//
//        // 3. 生成JWT（使用最新API）
//        String jwt = Jwts.builder()
//                .claims(claims)
//                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1小时后过期
//                .signWith(key, Jwts.SIG.HS256) // 使用最新签名方法常量
//                .compact();
//
//        System.out.println("生成的JWT: " + jwt);
//    }
////eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0ZXN0IiwiZXhwIjoxNzQ1OTE1NzUxfQ.TaiAP3zzjHrrP_9sNYGs8fDzDN4ygAvVhiE9VqfXLZU
//
//
//    @Test
//    public void testParseJWT() {
//        // 1. 准备相同的密钥（Base64解码）
//        String base64Key = "dGhpcyBpcyBhIHNlY3VyZSBrZXkgZm9yIEpXVCAyNTYgYml0cw==";
//        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
//        SecretKey key = new SecretKeySpec(keyBytes, "HmacSHA256");
//
//        // 2. 要解析的JWT（硬编码示例）
//        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0ZXN0IiwiZXhwIjoxNzQ1OTE2MzE4fQ.81lylnAh2RCrexPKGTZylvoi9fGcTUIdC7MkOC_ctwM";
//
//        try {
//            // 3. 解析JWT（使用最新API）
//            Claims claims = Jwts.parser()
//                    .verifyWith(key)
//                    .build()
//                    .parseSignedClaims(jwt)
//                    .getPayload();
//
//            System.out.println("解析出的Claims: " + claims);
//            System.out.println("用户ID: " + claims.get("id"));
//            System.out.println("用户名: " + claims.get("username"));
//        } catch (Exception e) {
//            System.err.println("JWT解析失败: " + e.getMessage());
//        }
//    }
}
