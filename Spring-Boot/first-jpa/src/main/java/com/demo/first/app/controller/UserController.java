package com.demo.first.app.controller;

import com.demo.first.app.model.User;
import com.demo.first.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/user")    // sare ends points user par honge
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService =  userService;
    }


// hame status code change karke 200 ke bajay 201 karna hai
@PostMapping // kyunki yha ham recource create kar rhe hai...   postmapping ki help se ak method ko map kar diya hai
public ResponseEntity<User> createUser(@RequestBody User user) {     // jisme user ki ak object aa jayegi     ,,,, RequestBody -->> Post request me hm RequestBody bhejte hai

    User createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
 }


    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updated = userService.updateUser(user);
        if (updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(updated);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        boolean isDeleted  = userService.deleteUser(id);
         if (!isDeleted)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.noContent().build();
    }


        // jo user delete ho gya usko fir se pane ke liye ]
    @GetMapping
    public List<User> getUser() {
          return userService.getAllUsers();
    }
         @GetMapping("{userId}")

        public ResponseEntity<User> getUser(@PathVariable(value = "userId",required = false) int id) {   // iska use karte h agr  orderId -- ye akbhi userId available na ho to
             User user = userService.getUserById(id);       // user -- user ka object return karega jo User se milega
            if (user == null)           // agar ye condition true ho jati hai  to not found return kar dega
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.ok(user);
         }
            // kya ak url me multiple path variable except kr skte h ? ---    yes kar skate hai
             @GetMapping("{userId}/orders/{orderId}")    // orderId -- ye akbhi available hoga kabhi nhi uske liye ... agar available nhi h to isko optional mark kar dete h
            public ResponseEntity<User> getUserOrder(
                    @PathVariable("userId") int id,
                   @PathVariable int orderId
            ){
                User user = userService.getUserById(id);       // user -- user ka object return karega jo User se milega
                if (user == null)           // agar ye condition true ho jati hai  to not found return kar dega
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                return ResponseEntity.ok(user);
            }

            // hame search API bnani h
          // /search?name=john
           @GetMapping("/search")
     public ResponseEntity<List<User>> searchUsers(
             @RequestParam(required = false, defaultValue = "alice") String name,
             // ham multiple RequestParam bhi pass kar sakte hai ,,, ye tabhi kam aate hai jab hame search  aur multiple level ke functioality bna rhe hai
             @RequestParam(required = false, defaultValue = "email") String email
             ) {     // agar jo ham value pass kar rhe h vo consider hogi nhi to default value consider ho jayegi
                return ResponseEntity.ok(userService.searchUsers(name,email));
           }

           @GetMapping("/info/{id}")
    public String getInfo(
            @PathVariable int id,
            @RequestParam String name,
            @RequestHeader("User-Agent") String userAgent) {
    return "User Agent: " + userAgent
            + " : " + id
            + " : " + name;
           }

}






