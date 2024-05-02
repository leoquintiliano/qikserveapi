//package br.com.leadersofts.qikserve.infrastructure.security.service;
//
//
//import br.com.leadersofts.qikserve.infrastructure.security.User;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//@Service
//public class TokenService {
//
//    @Value("${api.security.token.secret}")
//    private String secret;
//
//    public String generateToken(User user) {
//        try{
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            String token = JWT.create()
//                    .withIssuer("api-okta-storage")
//                    .withSubject(user.getLogin())
//                    .withExpiresAt(genExpirationDate())
//                    .sign(algorithm);
//            return token;
//        } catch (JWTCreationException exception) {
//            throw new RuntimeException("Error while trying to generate token ", exception);
//        }
//    }
//
//    public String validateToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            return JWT.require(algorithm)
//                    .withIssuer("api-okta-storage")
//                    .build()
//                    .verify(token)
//                    .getSubject();
//        } catch (JWTVerificationException exception){
//            return "";
//        }
//    }
//
//    private Instant genExpirationDate(){
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }
//
//}
