package com.facebook.facebook.service;


import com.facebook.facebook.modal.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> saveUser(UserDto userDto);

    ResponseEntity<?> findUser(String email, String password);
}

