package com.edureka.spring1.secureapi.repository;

import com.edureka.spring1.secureapi.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findUserByUsername(String username);

    Optional<UserAccount> findByUsername(String username);
}
