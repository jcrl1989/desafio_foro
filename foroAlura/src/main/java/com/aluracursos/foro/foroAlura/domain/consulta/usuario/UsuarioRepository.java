package com.aluracursos.foro.foroAlura.domain.consulta.usuario;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository {
    static UserDetails findByLogin(String username) {
        return null;
    }

    boolean findById(Long idUsuario);
}
