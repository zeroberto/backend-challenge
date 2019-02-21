package com.invillia.acme.security;

import com.invillia.acme.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class responsible for assisting in the use of GrantedAuthorities and UserRoles.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public final class GrantedAuthorityUtils {

    /**
     * Get a list of GrantedAuthorities from the UserRoles set.
     *
     * @param userRoles User roles.
     * @return A list of GrantedAuthorities.
     */
    public static List<GrantedAuthority> toGrantedAuthorities(Set<UserRole> userRoles) {
        return userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.roleName())).collect(Collectors.toList());
    }

}
