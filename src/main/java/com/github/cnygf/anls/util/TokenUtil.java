package com.github.cnygf.anls.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.cnygf.anls.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Token验证类
 *
 * @author YGF
 * @since 2019-09-18
 */
public class TokenUtil {

    /**
     * 安全字符串
     */
    private static String secret = "4HmosqFaAYM30x53";
    /**
     * 过期时间（秒）
     */
    private static long expire = 60000;

    /**
     * 签名并返回token
     * @param user 用户实体
     * @return token
     */
    public static String sign(User user) {
        String token = "";
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        token = Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(user.getUsername())
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
        return token;
    }

    /**
     * 判断token是否过期
     * @param expiration
     * @return true 过期
     */
    public static boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }

    /**
     * 验证token
     * @param token
     * @return 用户名
     */
    public static String tokenCheck(String token){
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        if(claims == null || isTokenExpired(claims.getExpiration())){
            return "";
        }
        return claims.getSubject();
    }

}
