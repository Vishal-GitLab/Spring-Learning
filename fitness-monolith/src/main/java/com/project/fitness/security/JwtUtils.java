package com.project.fitness.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

// is class ka use ham helper method me karenge aur isme ham  jaise token ki sari information is code ko ham dusri me class me use karenge
@Component
public class JwtUtils {

    // ye secrate ham jwt se karnege
    private String jwtSecret = "YS1zdHJpbmctc2VjcmV0LWF0LWxlYXN0LTI1Ni1iaXRzLWxvbmc=";             // jo key hai vo iske aginst sign hona hai aur validation bhi sighn hona  hai
    private int jwtExpirationMs = 172800000;                   // iska mat lab jab jwt ak bar issue hota hai to kitne time ke liye valid hai


    public String getJwtFromHeader (HttpServletRequest request) {
        String bearerToken  =  request.getHeader("Authorization");
        if (bearerToken !=  null && bearerToken.startsWith("Bearer "))
            return bearerToken.substring(7);           // ye btata hai ki -- ki phle ke jo 7 charachter hai usko chhod ke baki sabko print kar dega
        return  null;                                  // agar if if condition match nhi karti hai to ham return karenge null value
    }

    public String generateToken(String userId, String role) {   //   user password aur  authinticate karega    karega
        return Jwts.builder()
                .subject(userId)
                .claim("roles", List.of(role))
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpirationMs))        //  ye tab add hoga jab jab hamara 48 ghnte ki validation smapt ho jayegi tab
                .signWith(key())
                .compact();
    }

    public boolean validateJwtToken(String jwtToken) {      // 2 - fir token ko validate  karenege
        try{
            Jwts.parser().verifyWith((SecretKey) key  ()).build().parseSignedClaims( jwtToken);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }


    public String getUserIdFromToken(String jwt) {                           // hame user nikalna hai getUsernameFromToken se
        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(jwt)
                .getPayload().getSubject();                // is dono me user store hai
    }

    public Claims getAllClaims(String jwt) {
        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(jwt).getPayload();

    }
}














