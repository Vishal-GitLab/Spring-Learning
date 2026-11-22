package com.example.jpademo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserClassSpringBoot,Long> { // UserClassSpringBoot -- ye class hai jiske liye ham repository bna rhe hai      // Long -- ye type hai primary key ka

}
