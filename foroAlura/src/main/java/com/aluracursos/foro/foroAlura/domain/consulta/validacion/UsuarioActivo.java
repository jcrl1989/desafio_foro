package com.aluracursos.foro.foroAlura.domain.consulta.validacion;

import jakarta.validation.ValidationException;
import com.aluracursos.foro.foroAlura.domain.consulta.DataAgendaConsulta;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioActivo implements ValidacionConsulta {

    @Autowired
    private ForoRepository repository;

    public void validar(DataAgendaConsulta datos) {
        if (datos.idForo()==null){
            return;
        }
        var foroActivo=repository.findActivoById(datos.idForo());
        if (!foroActivo){
            throw new ValidationException("no se pueden ingresar a foros inactivos");
        }
    }
}
