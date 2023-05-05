package com.example.grbkhd.util;

import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenCreate {
    //生成token
        public static String  getoken(User user) {
            //Jwts.builder()生成
            //Jwts.parser()验证
            System.out.println(user+"wqwwwwwww");
            JwtBuilder jwtBuilder =  Jwts.builder()
                    .setId(user.getUsername()+"")
                    .setSubject(user.getName())    //用户名
                    .setIssuedAt(new Date())//登录时间
                    .signWith(SignatureAlgorithm.HS256, "my-123").setExpiration(new Date(new
                            Date().getTime()+86400000));
            //设置过期时间
            //前三个为载荷playload 最后一个为头部 header
            System.out.println(jwtBuilder.compact());
            return  jwtBuilder.compact();
        }
        //解token
        public static Token tokenToOut(String token) {
            Claims claims = Jwts.parser()
                    .setSigningKey("my-123")
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("用户id:"+claims.getId());
            System.out.println("用户名:"+claims.getSubject());
            System.out.println("用户时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                    format(claims.getIssuedAt()));System.out.println("过期时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                    format(claims.getExpiration()));
            System.out.println("用户角色:"+claims.get("role"));
            Token token1 = new Token();
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"). format(claims.getExpiration());
            token1.setUsername(claims.getId());
            token1.setName(claims.getSubject());
            token1.setEndDate(date);
            return token1;
        }
}
