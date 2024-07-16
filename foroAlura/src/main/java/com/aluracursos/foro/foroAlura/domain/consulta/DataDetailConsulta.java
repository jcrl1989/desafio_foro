package com.aluracursos.foro.foroAlura.domain.consulta;

import java.time.LocalDateTime;

public record DataDetailConsulta(Long id, Long idUsuario, Long idForo, LocalDateTime fecha) {

    public DataDetailConsulta(Consulta consulta) {
        this(consulta.getId(),consulta.getUsuario().getId(),consulta.getForo().getId(),consulta.getFecha());
    }

}
