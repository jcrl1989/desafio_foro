package com.aluracursos.foro.foroAlura.domain.consulta.foro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ForoRepository extends JpaRepository<Foro, Long> {

     Page<Foro> findByActivoTrue(Pageable paginacion);

     @Query("""
             select f from Foro f
             where f.activo= 1
             and
             f.tipo=:tipo
             and
             f.id not in(
                  select c.foro.id from Consulta c
                  where
                  c.fecha=:fecha
             )
             order by rand()
             limit 1
             """)

    Boolean findActivoById(Long idForo);

    Foro seleccionarForoEnFecha(LocalDateTime fecha);
}
