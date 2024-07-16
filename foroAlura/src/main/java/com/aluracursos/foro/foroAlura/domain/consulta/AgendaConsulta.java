package com.aluracursos.foro.foroAlura.domain.consulta;

import com.aluracursos.foro.foroAlura.domain.consulta.usuario.UsuarioRepository;
import com.aluracursos.foro.foroAlura.domain.consulta.validacion.ValidacionConsulta;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.Foro;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.ForoRepository;
import com.aluracursos.foro.foroAlura.infra.errores.ValidacionIntegridad;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

public class AgendaConsulta {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ForoRepository foroRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    List<ValidacionConsulta> validadores;

    public DataDetailConsulta agendar(DataAgendaConsulta datos) {
        if (!usuarioRepository.findById(datos.idUsuario())) {
            throw new ValidacionIntegridad("Este Id no fue encontrado");
        }

        if (datos.idForo()!=null && !foroRepository.existsById(datos.idForo())){
            throw new ValidacionIntegridad("Este id no fue encontrado");
        }

        validadores.forEach(v-> v.validar(datos));

        var usuario = usuarioRepository.findById(datos.idUsuario());

        Foro foro = null;
        var consulta = new Consulta(foro,usuario,datos.fecha());

        consultaRepository.save(consulta);

        return new DataDetailConsulta(consulta);
    }

    private Foro seleccionarForo(DataAgendaConsulta datos) {
        if (datos.idForo()!=null){
            return foroRepository.getReferenceById(datos.idForo());
        }
        return foroRepository.seleccionarForoEnFecha(datos.fecha());
    }
}


