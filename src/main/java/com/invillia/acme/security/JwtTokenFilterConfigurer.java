package com.invillia.acme.security;

import org.springframework.context.MessageSource;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Class responsible for configure the JWT Token Filter.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtTokenProvider jwtTokenProvider;
    private MessageSource messageSource;

    public JwtTokenFilterConfigurer(JwtTokenProvider jwtTokenProvider, MessageSource messageSource) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.messageSource = messageSource;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider, messageSource);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

}