package com.fls.metro.core.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 14:51
 */
class UserDetailsImpl implements UserDetails {

    private String username
    private String password
    private Boolean removed
    private Set<GrantedAuthority> authorities

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities
    }

    @Override
    String getPassword() {
        return password
    }

    @Override
    String getUsername() {
        return username
    }

    @Override
    boolean isAccountNonExpired() {
        return !removed
    }

    @Override
    boolean isAccountNonLocked() {
        return !removed
    }

    @Override
    boolean isCredentialsNonExpired() {
        return !removed
    }

    @Override
    boolean isEnabled() {
        return !removed
    }
}
