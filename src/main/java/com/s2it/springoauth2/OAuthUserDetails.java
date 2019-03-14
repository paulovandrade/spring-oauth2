package com.s2it.springoauth2;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class OAuthUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public OAuthUserDetails (final Long id, final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId () {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return this.authorities;
    }

    @Override
    public String getPassword () {
        return this.password;
    }

    @Override
    public String getUsername () {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return true;
    }
}
