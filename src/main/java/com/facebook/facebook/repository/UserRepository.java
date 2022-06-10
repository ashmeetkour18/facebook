package com.facebook.facebook.repository;

import com.facebook.facebook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String Email);
}
