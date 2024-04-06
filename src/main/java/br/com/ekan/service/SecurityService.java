package br.com.ekan.service;

import br.com.ekan.config.CodeError;
import br.com.ekan.config.JWTCreator;
import br.com.ekan.config.Token;
import br.com.ekan.config.TokenConfiguration;
import br.com.ekan.controller.request.UserRequest;
import br.com.ekan.exceptions.EntityResponseException;
import br.com.ekan.model.User;
import br.com.ekan.repository.UsuarioRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User usuario = usuarioRepository.findById(userName).orElseThrow(() ->
                new EntityResponseException("Email " + userName + " nao encontrado", CodeError.NOT_FOUND));

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority( "ALL"));

        UserDetails user = new org.springframework.security.core.userdetails.User(usuario.getUsuario(),"",authorities);

        return user;
    }

    public Token login(UserRequest request){

        User user = usuarioRepository.findById(request.getUsuario()).orElseThrow(() ->
                new EntityResponseException("Falha nas credenciais", CodeError.AUTH_ERROR));


        if(user!=null) {
            boolean passwordOk =  encoder.matches(request.getUsuario(), user.getSenha());
            if (!passwordOk) {
                throw new EntityResponseException("Falha nas credenciais", CodeError.AUTH_ERROR);
            }
            Token token = new Token();
            token.setIssuedAt(new Date());
            token.setExpiration(new Date(System.currentTimeMillis() + TokenConfiguration.EXPIRATION));
            token.setRoles(List.of("ALL"));
            token.setSubject(user.getUsuario());
            token.setType(TokenConfiguration.PREFIX);

            token.setAccessToken(JWTCreator.create(TokenConfiguration.PREFIX, TokenConfiguration.KEY, token));
            return token;
        }else {
            throw new EntityResponseException("Erro na autenticacao", CodeError.AUTH_ERROR);
        }
    }

    public boolean validateToken(final String token) {
        try {
             Jwts.parser().setSigningKey(TokenConfiguration.KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            return false;
        } catch (ExpiredJwtException ex) {
            return false;
        } catch (UnsupportedJwtException ex) {
            return false;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
