package com.aurora.mallcommon.util;




import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String key;
    private long time = 10;


    public String createToken(String openId) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        System.out.println("22222222222");
        long nowMillis = System.currentTimeMillis();
        long ttlMillis = nowMillis + (3600L * 1000L * time);
        Date now = new Date(nowMillis);
        Date exp = new Date(ttlMillis);

        Map<String,Object> claims = new HashMap<>();

        claims.put("open_id",openId);
//        claims.put("session_key",sessionKey);
        claims.put("created",now);
        claims.put("ttl",exp);
        System.out.println(openId);
//        System.out.println(sessionKey);

        String token = createToken(claims);
        System.out.println(token);
        return token;
    }

    private String createToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
    }

    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis()+time*1000*3600);
    }

    public String getUserNameFromToken(String token){
        String userName;
        try{
            Claims claims = getClaimsFromToken(token);
            userName = (String) claims.get("open_id");
        }catch (Exception e){
            userName = null;
        }
        return userName;
    }

    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            return null;
        }
        return claims;
    }

    public String refreshToken(String  token){
        Claims claims = getClaimsFromToken(token);
        claims.put("created",new Date());
        return createToken(claims);
    }

    public boolean isTokenExpired(String token){
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }
    private Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }



}
