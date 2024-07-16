package com.aluracursos.foro.foroAlura.domain.direccion;
import jakarta.validation.constraints.NotBlank;
public record DatosDireccion(
        @NotBlank
        String correo
) {


}
