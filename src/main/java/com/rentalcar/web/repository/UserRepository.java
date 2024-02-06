package com.rentalcar.web.repository;

import com.rentalcar.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String userName);

    UserEntity findFirstByUsername(String username);
}
