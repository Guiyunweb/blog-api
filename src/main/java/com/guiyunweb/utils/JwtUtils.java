package com.guiyunweb.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Guiyun
 * @date 2019/12/23 下午 2:21
 */
@Component
public class JwtUtils {

    private static final String PREFIX = "bearer ";
    private static JWTVerifier VERIFIER = null;


    public JwtUtils() {
    }


    public static String createToken(String id, Object obj) {
        try {
            String secret = "general";
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Map<String, Object> map = new HashMap();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            Date nowDate = new Date();
            String token = JWT.create().withHeader(map).withIssuer("SERVICE").withSubject(new Gson().toJson(obj)).withAudience(new String[]{id}).withIssuedAt(nowDate).sign(algorithm);
            return "bearer " + token;
        } catch (JWTCreationException var7) {
            var7.printStackTrace();
        }

        return null;
    }

    public static String verifyToken(String token) {
        try {
            JWTVerifier verifier = getVerifier();
            DecodedJWT jwt = verifier.verify(token.replace(PREFIX, ""));
            List<String> audience = jwt.getAudience();
            return (String)audience.get(0);
        } catch (Exception var4) {
            return null;
        }
    }

    private static JWTVerifier getVerifier() throws UnsupportedEncodingException {
        if (VERIFIER == null) {
            Algorithm algorithm = Algorithm.HMAC256("general");
            VERIFIER = JWT.require(algorithm).withIssuer("SERVICE").build();
        }
        return VERIFIER;
    }
}
