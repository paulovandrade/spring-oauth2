package com.s2it.springoauth2;

import com.s2it.springoauth2.model.UserEntity;
import com.s2it.springoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OAuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername (final String email) throws UsernameNotFoundException {
        final Optional<UserEntity> user = userService.findByEmail(email);

        if (user.isPresent()) {
            return OAuthUserDetailsFactory.create(user.get());
        }

        throw new UsernameNotFoundException("Email não encontrado.");
    }
}
