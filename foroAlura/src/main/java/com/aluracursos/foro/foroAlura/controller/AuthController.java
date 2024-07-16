package com.aluracursos.foro.foroAlura.controller;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.aluracursos.foro.foroAlura.domain.consulta.usuario.AuthUsuario;
import com.aluracursos.foro.foroAlura.domain.consulta.usuario.Usuario;
import com.aluracursos.foro.foroAlura.infra.security.JWTToken;
import com.aluracursos.foro.foroAlura.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticacion", description = "obtener token para usuario asignado")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authUsuario(@RequestBody @Valid AuthUsuario authUsuario) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authUsuario.login(),
                authUsuario.clave());
        var usuarioAuth =authenticationManager.authenticate(authToken);
        var JWTToken =tokenService.generarToken((Usuario)usuarioAuth.getPrincipal());
        return ResponseEntity.ok(new JWTToken(JWTToken));
    }
}
