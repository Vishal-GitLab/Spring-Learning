package com.project.fitness.controller;

import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.LoginResponse;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.security.JwtUtils;
import com.project.fitness.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")        // ak aisa annotation hai jo Postmapping me jitne bhi controller bne hai uske aage ham ye "/api/users" lga denge
@RequiredArgsConstructor                //  ye unhi field ka consturtor bnayega jo fina hoga
public class AuthController {             // AuthController ka matlab hai ki login registration sari functionality bnane wale hai vo sab isme rhengi

    private final UserService userService;
           private final JwtUtils jwtUtils;                   // BiCript passwordEncoder  ka use kar rhe hai

    @PostMapping("/register")

    // is valid use karne se ham jo annotaion dto me pass kar rhe ha vo valid ho jayegi    ,,,,
    public ResponseEntity<UserResponse>register( @Valid  @RequestBody RegisterRequest registerRequest) {      // responseEntity ka use isliye karte hai taki hamko better code mil sake        // isme user return karega

        // validation code -- ye check karega ki jo request  aa rhi hai vo valid hai ki nahi  ,, agar valid nhi hai to response bhi chla jayega error ke sath

        return ResponseEntity.ok(userService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {

            User user  = userService.authenticate(loginRequest);

              String token = jwtUtils.generateToken(user.getId(), user.getRole().name());        // ye name pass karke de dega method ko

            return ResponseEntity.ok(new LoginResponse(token, userService.mapToResponse(user)));



        } catch (AuthenticationException e ) {
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }

    }
}














