package com.invillia.acme.security;

import com.invillia.acme.entity.User;
import com.invillia.acme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.invillia.acme.core.utils.ExceptionUtils.orElseThrows;
import static com.invillia.acme.security.GrantedAuthorityUtils.toGrantedAuthorities;
import static java.util.Objects.isNull;

/**
 * UserDetails sevice class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.findByUsername(username);

        orElseThrows(isNull(user), new UsernameNotFoundException("User '" + username + "' not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(toGrantedAuthorities(user.getRoles()))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}