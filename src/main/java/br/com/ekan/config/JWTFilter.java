package br.com.ekan.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JWTFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token =  request.getHeader(JWTCreator.HEADER_AUTHORIZATION);
        try {
            if(token!=null && !token.isEmpty()) {
                Token tokenObject = JWTCreator.createToken(token, TokenConfiguration.PREFIX, TokenConfiguration.KEY);

                UsernamePasswordAuthenticationToken userToken =
                        new UsernamePasswordAuthenticationToken(
                                tokenObject.getSubject(),
                                null);

                SecurityContextHolder.getContext().setAuthentication(userToken);

            }else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        }catch (Exception e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
    }

}