package com.smile.application.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smile.application.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by agulshan on 17/11/17.
 */
public class FirebaseAuthFilter extends OncePerRequestFilter {

    private final UserService userService;

    public FirebaseAuthFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("FirebaseAuth");
        if(StringUtils.isEmpty(token)){
            filterChain.doFilter(request,response);
        }

    }
}
