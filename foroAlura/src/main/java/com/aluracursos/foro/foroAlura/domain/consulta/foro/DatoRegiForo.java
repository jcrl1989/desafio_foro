package com.aluracursos.foro.foroAlura.domain.consulta.foro;

import com.aluracursos.foro.foroAlura.domain.direccion.DatosDireccion;
import com.aluracursos.foro.foroAlura.domain.direccion.Direccion;
import jakarta.validation.constraints.*;

public record DatoRegiForo(
        @NotBlank
        String nombre,
        @NotBlank
        String tipo
) {

        public DatosDireccion direccion(Direccion direccion) {
               return this.direccion(direccion= direccion);
        }
}
