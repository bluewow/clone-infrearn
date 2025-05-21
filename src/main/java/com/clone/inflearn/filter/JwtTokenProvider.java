package com.clone.inflearn.filter;

import com.clone.inflearn.util.auth.CustomAuthentication;
import com.clone.inflearn.util.auth.CustomPrincipal;
import com.clone.inflearn.util.exception.CustomException;
import com.clone.inflearn.util.exception.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private static final String ISS = "Connect";
    private static final long HOUR = 1000L * 60 * 60;
    private static final long DAY = HOUR * 24;
    private static final long ACCESS_TOKEN_VALID_TIME = DAY * 7; // 7일

    @Value("${jwt.token.key}")
    private String key;

    public String createAccessToken(Long id) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(Long.toString(id))
                .setIssuer(ISS)
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }


    public void validateCheck(String token) {
        try {
            Date expiration = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            if (expiration.before(new Date())) {
                throw new CustomException(ErrorCode.JWT_EXPIRED);
            }
        } catch (Exception e) {
            throw new CustomException(ErrorCode.AUTH);
        }
    }

    public Authentication getAuthentication(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        String subject = body.getSubject();
        CustomPrincipal principal = new CustomPrincipal(Long.parseLong(subject));

        return new CustomAuthentication(principal, null, Collections.emptyList());
    }
}
