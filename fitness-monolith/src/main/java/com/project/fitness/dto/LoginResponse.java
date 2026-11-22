package com.project.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
   private String token;
          private UserResponse user;              // dusre class ka object hai jise  ham pass kar rhe hai

}
