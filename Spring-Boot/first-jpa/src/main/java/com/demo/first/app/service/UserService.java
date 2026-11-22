package com.demo.first.app.service;


import com.demo.first.app.exception.UserNotFoundException;
import com.demo.first.app.model.User;
import com.demo.first.app.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service                       // spring boot user service ki use se khud manage kare
public class    UserService {
    private   UserRepository userRepository;
//    private Map<Integer, User> userDb = new HashMap<>();
      private final Logger  logger = LoggerFactory.getLogger(UserService.class);

      // ak autowire bnayenge

    public User createUser(User user) {
             logger.info("Creating user.. INFO");
             logger.debug("Creating user.. DEBUG");
             logger.trace("Creating user.. TRACE");
             logger.warn("Creating user.. WARN");
             logger.error("Creating user.. ERROR");
        System.out.println(user.getEmail());
         if (user.getProfile() != null)
             user.getProfile().setUser(user);
         if (user.getPosts() !=  null)
             user.getPosts().forEach(post -> post.setUser(user));

//        userDb.putIfAbsent(user.getId(), user);
          return  userRepository.save(user);
    }

    public User updateUser(User user) {
               User existing = userRepository.findById(user.getId())
                .orElseThrow(
                () -> new UserNotFoundException( "User with id" + user.getId() + "does  not exist")
        );         // aga exception aata hai to ye yhi se run kar dega

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
         return userRepository.save(existing);      // existing -- jo user hai usko save kar diya
    }
     public boolean deleteUser(int id) {
        if (!userRepository.existsById(id))       // agar ye exist nahi karta hai to error throw kar denge
//            return false;                    // mujhe exception generate karna hai jo in built exception hai
            throw  new UserNotFoundException("User with id"+ id + "does  not exist");
         userRepository.deleteById(id);               // fir uske bad ham delete kar denge
        return  true;     //  agar yha se true return ho rha  hai to delete successful hai
    }

    public List<User> getAllUsers() {
        List<User> users  = userRepository.findAll();
        if (users.isEmpty())
            throw new NullPointerException("No user found in the database");
       return  users;
    }
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(
                        ()-> new UserNotFoundException( "User with id" + id + "does  not exist")
                );
    }

    public @Nullable List<User> searchUsers(String name, String email) {
           return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name,email);      // find -- search ke liye use karenge .... By ---> where classs use karenge by ke liye      .. NameAndEmail --> Name aur Email  ak field  hai dono condition satisfied honi chahiye
//           return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name,email);
    }
}


































