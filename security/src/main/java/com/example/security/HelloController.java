package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    AuthenticationManager authenticationManager;     // AuthenticationManager -- ye ak interface hai aur ye jo request aati h usko aunthicate karta hai

    @Autowired
    JwtUtils jwtUtils;

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")     // jo hello ki end point hai vo sirf ADMIN hi acess kar skta hai bas
    @GetMapping("/hello")
     public String sayHello() {
        return "Hello";
    }

    // admin ko access hone wali API
    @GetMapping("/admin/hello")

    public String sayAdminHello() {
        return "Hello, Admin";
    }


    @GetMapping("/user/hello")
     public String sayUserHello() {
        return "Hello,User";
    }

    // ak end  point generate karunga jiske jariye hm token ko generate kar skte h
    @PostMapping("/signin")
    public String login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                 )
            );
        } catch (AuthenticationException e ) {
            e.printStackTrace();
            return "Could not authenticate";
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails=  (UserDetails) authentication.getPrincipal();       // UserDetails -- iski help se ham retrive karta hai
         String jwtToken  = jwtUtils.generateTokenFromUsername(userDetails);    // ye hme jwt ka token de dega
        return jwtToken;
    }

}
















