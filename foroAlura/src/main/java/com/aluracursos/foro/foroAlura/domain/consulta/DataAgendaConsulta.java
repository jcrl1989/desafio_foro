package com.aluracursos.foro.foroAlura.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.TipoForo;

import java.time.LocalDateTime;

public record DataAgendaConsulta(
        @NotNull
        Long idUsuario,
        Long idForo,

        @NotNull
        @Future
        LocalDateTime fecha,

        TipoForo tipoForo) {



}
