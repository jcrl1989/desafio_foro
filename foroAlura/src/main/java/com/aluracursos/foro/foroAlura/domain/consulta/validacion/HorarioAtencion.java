package com.aluracursos.foro.foroAlura.domain.consulta.validacion;


import com.aluracursos.foro.foroAlura.domain.consulta.DataAgendaConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioAtencion implements ValidacionConsulta {

    public void validar(DataAgendaConsulta datos) {
        var domingo= DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());
        var antesApertura=datos.fecha().getHour()<7;
        var despuesCierre=datos.fecha().getHour()>19;
        if (domingo || antesApertura || despuesCierre){
            throw new ValidationException("acceso a foro fuera de horario");
        }
    }
}
