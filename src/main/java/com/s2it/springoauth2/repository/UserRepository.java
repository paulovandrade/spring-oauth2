package com.s2it.springoauth2.repository;

import com.s2it.springoauth2.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional(readOnly = true)
    UserEntity findByEmail(String email);

}
