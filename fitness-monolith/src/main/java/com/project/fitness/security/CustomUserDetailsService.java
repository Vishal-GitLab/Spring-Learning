package com.project.fitness.security;

import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

      // user kaise fetch karna hai vo mujhe btana hai spring ko


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {   // loadUserByUsername  -->> ye core specific data ko load karta hai
       User user =  userRepository.findByEmail(email);
          if (user ==  null) {
              throw new RuntimeException("User not found" +  email);
          }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())       // getRole -->>> hmko enum return kar rha hai
                .build();
    }         // isme hamara sara detail

}
















