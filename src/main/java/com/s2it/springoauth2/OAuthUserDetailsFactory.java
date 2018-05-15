package com.s2it.springoauth2;

import com.s2it.springoauth2.model.RoleEnum;
import com.s2it.springoauth2.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class OAuthUserDetailsFactory {

    public static OAuthUserDetails create(UserEntity user) {
        return new OAuthUserDetails(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getRole()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(RoleEnum roleEnum) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleEnum.toString()));
        return authorities;
    }

}
