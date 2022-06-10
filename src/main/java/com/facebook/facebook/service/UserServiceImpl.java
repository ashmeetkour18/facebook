package com.facebook.facebook.service;

import com.facebook.facebook.entity.User;
import com.facebook.facebook.modal.UserDto;
import com.facebook.facebook.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        User user1 = userRepository.save(user);
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findUser(String email, String password) {
        List<User> userList =
                userRepository.findAll().stream().filter(a -> a.getEmail().equals(email) && a.getPassword().equals(password)).collect(Collectors.toList());
        if (userList.size() > 0) {
            System.out.println(userList);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
        return new ResponseEntity<>("Wrong Credentials", HttpStatus.BAD_REQUEST);
    }
}
