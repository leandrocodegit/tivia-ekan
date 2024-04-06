package br.com.ekan.config;

import io.jsonwebtoken.*;

import java.util.List;
import java.util.stream.Collectors;

public class JWTCreator {


    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix, String key, Token token) {
        return Jwts.builder().setSubject(token.getSubject()).setIssuedAt(token.getIssuedAt()).setExpiration(token.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(token.getRoles())).signWith(SignatureAlgorithm.HS512, key).compact();
    }

    public static Token createToken(String token, String prefix, String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        Token object = new Token();
        token = token.replace(prefix, "");
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        object.setRoles((List<String>) claims.get(ROLES_AUTHORITIES));
        return object;

    }

    private static List<String> checkRoles(List<String> roles) {
        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_", ""))).collect(Collectors.toList());
    }
}
