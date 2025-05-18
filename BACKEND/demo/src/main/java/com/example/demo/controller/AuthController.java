package com.example.demo.controller;

import com.example.demo.service.AuthService;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        try {
            String token = authService.login(username, password);
            Optional<User> userOpt = userRepository.findByUsername(username);

            if (userOpt.isPresent()) {
                Role role = userOpt.get().getRole(); // ✅ Get Enum role
                return ResponseEntity.ok(Map.of("token", token, "role", role.name())); // ✅ Return Enum as String
            }

            return ResponseEntity.status(401).body("Invalid credentials");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
