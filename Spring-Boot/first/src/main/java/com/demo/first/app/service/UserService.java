package com.demo.first.app.service;


import com.demo.first.app.exception.UserNotFoundException;
import com.demo.first.app.model.User;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service                       // spring boot user service ki use se khud manage kare
public class UserService {
    private Map<Integer, User> userDb = new HashMap<>();
      private final Logger  logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(User user) {
             logger.info("Creating user.. INFO");
             logger.debug("Creating user.. DEBUG");
             logger.trace("Creating user.. TRACE");
             logger.warn("Creating user.. WARN");
             logger.error("Creating user.. ERROR");
        System.out.println(user.getEmail());
        userDb.putIfAbsent(user.getId(), user);
          return user;
    }

    public User updateUser(User user) {
        if (!userDb.containsKey(user.getId())) {
//                   throw  new IllegalArgumentException("User with id"+ user.getId() + "does  not exist");
            logger.error("Error when finding user with id {}", user.getId());
            throw new UserNotFoundException("User with id" + user.getId() + "does  not exist");
        }
        userDb.put(user.getId(),user);
        return user;

    }
     public boolean deleteUser(int id) {
        if (!userDb.containsKey(id))
//            return false;                    // mujhe exception generate karna hai jo in built exception hai
            throw  new UserNotFoundException("User with id"+ id + "does  not exist");
         userDb.remove(id);
        return  true;     //  agar yha se true return ho rha  hai to delete successful hai
    }

    public List<User> getAllUsers() {
        if (userDb.isEmpty())
            throw new NullPointerException("No user found in the database");
       return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {
        return userDb.get(id);
    }

    public @Nullable List<User> searchUsers(String name, String email) {
             return    userDb.values().stream()
                       .filter(u -> u.getName().equalsIgnoreCase(name))
                       .filter(u -> u.getEmail().equalsIgnoreCase(email))
                       .toList();
    }
}


















