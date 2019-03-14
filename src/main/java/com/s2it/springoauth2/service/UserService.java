package com.s2it.springoauth2.service;

import java.util.Optional;

import com.s2it.springoauth2.model.UserEntity;
import com.s2it.springoauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

}
