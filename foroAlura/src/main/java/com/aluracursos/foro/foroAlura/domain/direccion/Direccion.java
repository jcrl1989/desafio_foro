package com.aluracursos.foro.foroAlura.domain.direccion;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {

    private String correo;

    private String correoAlter;

    public Direccion(DatosDireccion direccion) {
        this.correo = direccion.correo();
        this.correoAlter = direccion.correoALter();
    }

    public Direccion actualizarDireccion(DatosDireccion direccion){
        this.correo = direccion.correo();
        this.correoAlter = direccion.correoALter();
        return this;
    }
}
