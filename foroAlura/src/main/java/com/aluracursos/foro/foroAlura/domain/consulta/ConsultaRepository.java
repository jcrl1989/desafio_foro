package com.aluracursos.foro.foroAlura.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long>{

    Boolean existByUserAndFechaBetween(Long idUsuario, LocalDateTime primerHorario, LocalDateTime ultimoHorario);

    Boolean existByForoAndFecha(Long idForo, LocalDateTime fecha);
}
