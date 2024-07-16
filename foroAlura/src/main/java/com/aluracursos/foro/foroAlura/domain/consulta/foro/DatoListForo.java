package com.aluracursos.foro.foroAlura.domain.consulta.foro;

public record DatoListForo(Long id, String nombre, String tipo, String s) {

    public DatoListForo(Foro foro) {
        this(foro.getID, foro.getNombre, foro.getDireccion, foro.GetTipo().toString());
    }

}
