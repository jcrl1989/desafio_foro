package com.aluracursos.foro.foroAlura.domain.consulta.validacion;

import jakarta.validation.ValidationException;
import com.aluracursos.foro.foroAlura.domain.consulta.DataAgendaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAnticipa implements ValidacionConsulta {

    public void validar(DataAgendaConsulta datos) {
        var ahora=LocalDateTime.now();
        var horaConsulta=datos.fecha();

        var diferencia30Min=Duration.between(ahora,horaConsulta).toMinutes()<30;
        if (diferencia30Min){
            throw new ValidationException("Consultas deben hacerse con al menos 30 minutos");
        }
    }
}
