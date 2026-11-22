package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity              // ye security enable karega
@EnableMethodSecurity          // method based Seurity se access karne ke liye ham iska use karte hai
public class SecurityConfig {

    @Autowired
    // iska use karte hai data base se connect karne ke liye
    DataSource dataSource;           // jo bhi data base connection hai vo yha pass kar dega

    @Autowired
    AuthTokenFilter authTokenFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers("/admin/**").hasRole("ADMIN")    // hasRole ka use isliye kar rhe taki isko sirf ADMIN hi access kar sake
                                .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/signin").permitAll()
                 .anyRequest().authenticated());

//        http.httpBasic( .withDefaults());

        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class); //  ye user ke authentication ke pahle hi exist karega
        return http.build();


    }

      @Bean  // Bean ka use karte hi ye spring manage cmponente ho jayega
    public UserDetailsService  userDetailsService() {
          UserDetails user1  = User.withUsername("user1")
//                  .password("{noop}password1")
                  .password(passwordEncoder().encode("password1"))
                  .roles("USER")    // ye isko store karta hai ROLE_USER ke form me
                  .build();
          UserDetails user2  = User.withUsername("user2")
//                  .password("{noop}password2")
                 .password(passwordEncoder().encode("password2"))

                  .roles("USER")   //  ye isko store karta hai ROLE_ADMIN ke form me
                  .build();
          UserDetails admin  = User.withUsername("admin")
//                  .password("{noop}adminPassword")
               .password(passwordEncoder().encode("adminPassword"))

                  .roles("ADMIN")
                  .build();
//          return  new InMemoryUserDetailsManager(user1,user2, admin);

          JdbcUserDetailsManager userDetailsManager  = new JdbcUserDetailsManager(dataSource);      // datasource   iska matlab data base kaha hai

          if (!userDetailsManager.userExists(user1.getUsername())) {
              userDetailsManager.createUser(user1);
          }

          if (!userDetailsManager.userExists(user2.getUsername())) {
              userDetailsManager.createUser(user2);
          }
          if (!userDetailsManager.userExists(admin.getUsername())) {
              userDetailsManager.createUser(admin);
          }
           return userDetailsManager;

          // isko use karne ke liye hame SecurityCong me jana padega
      }

      @Bean
       BCryptPasswordEncoder passwordEncoder() {    // jaha ham security ka use karte hai to ye vha use hoti hai
        return new BCryptPasswordEncoder();          // BCryptPasswordEncoder ka instance return karega
      }

        @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) {
        return builder.getAuthenticationManager();
        }
}






