package com.invillia.acme.config;

import com.invillia.acme.security.JwtTokenFilterConfigurer;
import com.invillia.acme.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import static com.invillia.acme.constants.PathsConstants.Groups.*;
import static com.invillia.acme.constants.PathsConstants.*;
import static com.invillia.acme.enums.UserRole.ADMIN;
import static com.invillia.acme.enums.UserRole.SELLER;

/**
 * Class containing the security configurations.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private MessageSource messageSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()

                // User
                .antMatchers(HttpMethod.POST, USER_PATH + USER_LOGIN_PATH).permitAll()
                .antMatchers(HttpMethod.POST, USER_PATH + USER_SIGNUP_PATH).permitAll()

                // Admin
                .antMatchers(HttpMethod.POST, ADMIN_CRITICAL_PATHS).hasRole(ADMIN.name())
                .antMatchers(HttpMethod.PUT, ADMIN_CRITICAL_PATHS).hasRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE, ADMIN_CRITICAL_PATHS).hasRole(ADMIN.name())
                .antMatchers(HttpMethod.PATCH, ADMIN_CRITICAL_PATHS).hasRole(ADMIN.name())

                // Seller
                .antMatchers(HttpMethod.POST, SELLER_CRITICAL_PATHS).hasRole(SELLER.name())
                .antMatchers(HttpMethod.PUT, SELLER_CRITICAL_PATHS).hasRole(SELLER.name())
                .antMatchers(HttpMethod.DELETE, SELLER_CRITICAL_PATHS).hasRole(SELLER.name())
                .antMatchers(HttpMethod.PATCH, SELLER_CRITICAL_PATHS).hasRole(SELLER.name())

                // Any
                .anyRequest().authenticated()
                .and()
                .apply(new JwtTokenFilterConfigurer(jwtTokenProvider, messageSource))
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(SWAGGER_PATHS);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
