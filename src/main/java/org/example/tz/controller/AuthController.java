package org.example.tz.controller;

import org.example.tz.dto.AuthResponse;
import org.example.tz.dto.LoginRequest;
import org.example.tz.dto.RegisterRequest;
import org.example.tz.model.User;
import org.example.tz.security.JwtUtil;
import org.example.tz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userService.existsByEmail(request.getEmail()) || userService.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(Collections.singleton("USER"))
                .enabled(true)
                .build();
        userService.registerUser(user);
        String token = jwtUtil.generateToken(user.getUsername(), user.getRoles());
        return ResponseEntity.ok(new AuthResponse(token, "Bearer", 3600));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userService.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> {
                    String token = jwtUtil.generateToken(user.getUsername(), user.getRoles());
                    return ResponseEntity.ok(new AuthResponse(token, "Bearer", 3600));
                })
                .orElseGet(() -> ResponseEntity.status(401).body(null));
    }

    @GetMapping("/me")
    public ResponseEntity<?> profile(Principal principal) {
        if (principal == null) return ResponseEntity.status(401).body("Unauthorized");
        return userService.findByUsername(principal.getName())
                .map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }
} 