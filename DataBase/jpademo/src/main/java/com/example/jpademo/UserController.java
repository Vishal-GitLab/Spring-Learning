package com.example.jpademo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService =  userService;
    }

    @PostMapping    // postmapping "/users" point se link haii
    public UserClassSpringBoot createUser(@RequestBody UserClassSpringBoot user ) {   // requestmappping poastmapping se aayegi jo bhi aayegi vo JPA ke UserClassSpringBoot se aayegi 
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserClassSpringBoot> getUser() {    // ye aisi ends poin hai jo sare user ki list degi
        return userService.getAllUsers();
    }

}





