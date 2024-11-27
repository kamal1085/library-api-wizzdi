package com.compare.comparenocode.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.compare.comparenocode.service.AuthService;
import com.compare.comparenocode.service.UserService;
import com.compare.comparenocode.entity.AppUser;
import com.compare.comparenocode.model.UserLogin;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody UserLogin user) {
        AppUser userNew = new AppUser();
        userNew.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.save(userNew);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLogin user) {
        AppUser foundUser  = authService.getUser(user.getUserName());
        if (new BCryptPasswordEncoder().matches(user.getPassword(), foundUser.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
