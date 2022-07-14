/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.security.jwt;

import com.arg_prog.back.models.Usuarios;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.regex;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter  extends OncePerRequestFilter{
    @Autowired
    private JwtTokenUtil jwtUtil;
    
    /**
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        
        if(!hasAuthorizationBearer(request)){
            filterChain.doFilter(request, response);
            return;
        }
        
        String token = getAccessToken(request);
        
        if(!jwtUtil.validateAccessToken(token)){
            filterChain.doFilter(request, response);
            return;
        }
        
        setAuthenticationContext(token, request);
        filterChain.doFilter(request, response);
        
    }
       private boolean hasAuthorizationBearer(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        
        if(ObjectUtils.isEmpty(header) || header.startsWith("Bearer")){
            return false;
        }
            return true;
        }
       
       private String getAccessToken(HttpServletRequest request){
           String header = request.getHeader("Authorization");
           String token = header.split("")[1].trim();
           return token;
       }
       
       private void setAuthenticationContext(String token, HttpServletRequest request){
           UserDetails userDetails = getUserDetails(token);
           
           UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
           
           authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
           
           SecurityContextHolder.getContext().setAuthentication(authentication);
       }
       
       private UserDetails getUserDetails(String token){
           Usuarios userDetails = new Usuarios();
           String[] jwtSubject = jwtUtil.getSubject(token).split(",");
           
           userDetails.setId(Integer.parseInt(jwtSubject[0]));
           userDetails.setEmail(jwtSubject[1]);
           
           return userDetails;
       }
    
}
