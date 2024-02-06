package com.rentalcar.web.service;

import com.rentalcar.web.dto.RegistrationDto;
import com.rentalcar.web.models.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
