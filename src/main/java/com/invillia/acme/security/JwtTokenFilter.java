package com.invillia.acme.security;


import com.invillia.acme.http.exceptions.AsyncRequestException;
import com.invillia.acme.security.exceptions.InvalidTokenException;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

import static com.invillia.acme.http.utils.ExceptionsStatusMapper.getHttpStatus;
import static java.util.Objects.nonNull;

/**
 * JWT Token filter class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;
    private MessageSource messageSource;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider, MessageSource messageSource) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.messageSource = messageSource;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        try {
            if (nonNull(token) && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (InvalidTokenException ex) {
            SecurityContextHolder.clearContext();
            throw new ResponseStatusException(
                    getHttpStatus(ex.getClass()),
                    messageSource.getMessage(ex.getMessage(), null, Locale.getDefault()),
                    ex
            );
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}