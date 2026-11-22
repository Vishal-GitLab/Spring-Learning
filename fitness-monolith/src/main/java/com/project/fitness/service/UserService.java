package com.project.fitness.service;

import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor            // jab  ye lgayenge to automatically userRepository ka constructor generate ho jayega
public class UserService {
    private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;  // PasswordEncoder   -- yha ham iska use karenge


    public UserResponse register(RegisterRequest request) {
        UserRole rle = request.getRole() != null ?  request.getRole() : UserRole.USER;          // agar nhi hai to hm null return kra denge agar hai to hm user ka role return kar denge
        User user = User.builder()          // iski help se ham object bnate hai
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(rle)
                .build();
//        User user  = new User(
//           null,
//          request.getEmail(),
//          request.getPassword(),
//          request.getFirstName(),
//                request.getLastName(),
//                Instant.parse("2026-08-26T05:31:40Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2026-08-26T05:31:40Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                       null,
//                null,
//                List.of(),
//                List.of()
//        );
        User saveUser = userRepository.save(user);
        return mapToResponse(saveUser);          // hame user response ki need hai
    }

    public  UserResponse mapToResponse(User saveUser) {
        UserResponse response = new UserResponse();
        response.setId(saveUser.getId());
        response.setEmail(saveUser.getEmail());
        response.setPassword(saveUser.getPassword());
        response.setFirstName(saveUser.getFirstName());
        response.setLastName(saveUser.getLastName());
        response.setCreatedAt(saveUser.getCreatedAt());
        response.setUpdateAt(saveUser.getUpdatedAt());
        return response;
    }

    public User authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null) {
            throw new RuntimeException("Invalid Credentials");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }
         return user;
    }
}













