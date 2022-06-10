package com.facebook.facebook.controller;

import com.facebook.facebook.exceptions.UserException;
import com.facebook.facebook.modal.AuthRequest;
import com.facebook.facebook.modal.AuthResponse;
import com.facebook.facebook.modal.UserDto;
import com.facebook.facebook.service.CustomUserDetailsService;
import com.facebook.facebook.service.UserService;
import com.facebook.facebook.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost")
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/user")
    public ResponseEntity<?> addUsers(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping("/r")
    public String loginSecurity() {
        return "Welcome to Facebook";
    }

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println(authRequest.getEmail() + " email " + authRequest.getPassword() + " password");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),
                    authRequest.getPassword()));
        } catch (BadCredentialsException exception) {
            throw new UserException("Invalid Credentials");
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getEmail());
        final String token = jwtUtil.generateToken(userDetails);
        System.out.println(token);
        return new AuthResponse(token);
    }
}
