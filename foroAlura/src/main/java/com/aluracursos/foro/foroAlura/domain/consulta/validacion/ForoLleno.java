package com.aluracursos.foro.foroAlura.domain.consulta.validacion;

import jakarta.validation.ValidationException;
import com.aluracursos.foro.foroAlura.domain.consulta.ConsultaRepository;
import com.aluracursos.foro.foroAlura.domain.consulta.DataAgendaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForoLleno implements ValidacionConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DataAgendaConsulta datos) {
        if (datos.idForo()==null)
            return;

        var forolleno = repository.existByForoAndFecha(datos.idForo(),datos.fecha());
        if (forolleno){
            throw new ValidationException("Foro lleno");
        }
    }
}
