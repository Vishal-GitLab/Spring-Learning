package com.demo.first.app.repository;


import com.demo.first.app.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {          // isko ham create kar liye JPA apne app se iski query bna lega hamko apne aapse nahi bnana padega
    @Nullable List<User> findByNameIgnoreCaseAndEmailIgnoreCase(String name, String email);
}
