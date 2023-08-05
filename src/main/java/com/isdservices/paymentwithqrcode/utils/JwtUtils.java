package com.isdservices.paymentwithqrcode.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secretKey;
    public String extractUserIdFromToken(String jwtToken) {
        try {
            // Parse the JWT token
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();

            // Extract the user ID from the "userId" claim
            String userId = (String) claims.get("userId");

            return userId;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String extractUserTypeFromToken(String jwtToken) {
        try {
            // Parse the JWT token
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();

            // Extract the user ID from the "userType" claim
            String userType = (String) claims.get("userType");

            return userType;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String extractToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring("Bearer ".length());
        }
        return null;
    }
}