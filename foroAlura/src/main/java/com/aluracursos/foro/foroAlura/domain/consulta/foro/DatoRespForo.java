package com.aluracursos.foro.foroAlura.domain.consulta.foro;

import com.aluracursos.foro.foroAlura.domain.direccion.DatosDireccion;

public record DatoRespForo(Long id, String nombre, String tipo, DatosDireccion direccion) {
}
