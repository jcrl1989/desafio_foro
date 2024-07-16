package com.aluracursos.foro.foroAlura.domain.consulta.foro;

import jakarta.validation.constraints.NotNull;
import com.aluracursos.foro.foroAlura.domain.direccion.DatosDireccion;

public record DatoActualForo(@NotNull Long id, String nombre, String tipo, DatosDireccion direccion) {
}
