package com.example.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component   // ye spring manage component hai
public class AuthTokenFilter extends OncePerRequestFilter {     // ye btayega ki ak  bar sirf ak chain sirf ak filter ke liye use hoga bas.... hamne isko imlement kar liya

    @Autowired
   private JwtUtils jwtUtils;

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Override

    // ye teeno hmare filter hai
    protected void doFilterInternal(HttpServletRequest request,     // ye hame incommin request deta hai
                                    HttpServletResponse response,      // ye out going response deta hai
                                    FilterChain filterChain) throws ServletException, IOException {            // FilterChain filterChain -- jo remaning filter  hoga  vo isme hoga  
        System.out.println("AuthTokenFilter Called");
        try {
            String jwt =  parseJwt(request);   // ab jwt ka token  aa gya hai hmare pass ab hme isko  aage  lekar jana hai
            if (jwt != null && jwtUtils.validateJwtToken(jwt)){
                System.out.println("TOKEN THERE: " + jwt);
                String username = jwtUtils.getUsernameFromToken(jwt);
//             UserDetails userDetails =  userDetailsService.loadUserByUsername(username);

                Claims claims = jwtUtils.getAllClaims(jwt);   // ye ak helper method hai ,,,    Claims -- ka matlab hai ki ye name value pair hai \
                List<String>  roles = claims.get("roles", List.class);
                System.out.println("ROLES: " + roles);
                List<GrantedAuthority> authorities  = List.of();          // empty list bnani hai
                if(roles != null) {
                     authorities = roles.stream()
                            .map(role -> (GrantedAuthority) new SimpleGrantedAuthority(role))
                            .toList();
                }
             UsernamePasswordAuthenticationToken authentication  =  new UsernamePasswordAuthenticationToken(username,null, authorities);

             authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request,response);      // is line ka matlb hai jo hmari chain bni hai vo vaise hi continue hi rhe ,, filter chain ko continue rhe
     }

     private String parseJwt(HttpServletRequest request) {
        String jwt  = jwtUtils.getJwtFromHeader(request);
        return jwt;
     }

}
