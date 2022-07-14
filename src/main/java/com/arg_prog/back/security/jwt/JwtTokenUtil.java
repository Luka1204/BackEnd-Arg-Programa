/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.security.jwt;

import com.arg_prog.back.models.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final long EXPIRE_DURATION=24*60*60*1000;
    
    @Value("${app.jwt.secret}")
    private String secretKey;
    
    public String generateAccesToken(Usuarios user){
        
        return Jwts.builder()
                .setSubject(user.getId() + "," + user.getEmail())
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    
    }
    
    public boolean validateAccessToken(String token){
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
                    return true;
        }catch(ExpiredJwtException ex){
            LOGGER.error("JWT expired", ex);
        }catch(IllegalArgumentException ex){
            LOGGER.error("Tokken is null, empty or has only whitespaces");
        }catch(MalformedJwtException ex){
            LOGGER.error("JWT is invalid", ex);
        }catch(UnsupportedJwtException ex){
            LOGGER.error("JWT is not supported", ex);
        }catch(SignatureException ex){
            LOGGER.error("signature validation failed",ex);
        }
        return false;
    }
    
    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }
    
    private Claims parseClaims(String token){
       return (Claims) Jwts.parser()
               .setSigningKey(secretKey)
               .parseClaimsJws(token)
               .getBody();
    }
}
