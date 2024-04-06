package br.com.ekan.controller;

import br.com.ekan.config.Token;
import br.com.ekan.controller.request.UserRequest;
import br.com.ekan.service.SecurityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Tag(name = "Auth controller", description = "Serviço de autenticação")
public class AuthController {

    @Autowired
    private SecurityService securityService;

    @Operation(summary = "Autenticação", description = "Retonar token jwt")
    @PostMapping
    public ResponseEntity<Token> login(@RequestBody UserRequest request){
        return ResponseEntity.ok(securityService.login(request));
    }

}
