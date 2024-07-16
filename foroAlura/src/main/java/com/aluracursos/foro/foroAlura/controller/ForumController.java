package com.aluracursos.foro.foroAlura.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.aluracursos.foro.foroAlura.domain.direccion.DatosDireccion;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping
@SecurityRequirement(name = "bearer-key")
public class ForumController {

    @Autowired
    private ForoRepository foroRepository;

    @PostMapping
    @Transactional
    @Operation(summary = "registra un nuevo foro en la base de datos")
    public ResponseEntity<DatoRespForo> registroForo(@RequestBody @Valid DatoRegiForo datoRegiForo,
                                                     UriComponentsBuilder uriComponentsBuilder) {


        URI url = null;
        DatoRespForo datoRespForo = null;
        return ResponseEntity.created(url).body(datoRespForo);
    }



    @PutMapping
    @Transactional
    @Operation(summary = "Obtiene listado Foros")
    public ResponseEntity actualizarForo(@RequestBody @Valid DatoActualForo datoActualForo) {
        Foro foro = foroRepository.getReferenceById(datoActualForo.id());
        foro.actualizarDatos(datoActualForo);
        return ResponseEntity.ok(new DatoRespForo(foro.getId(), foro.getNombre(), foro.getTipo(),
                new DatosDireccion(Foro.getDireccion)));
    }

    @DeleteMapping
    @Transactional
    @Operation(summary = "elimina un foro registrado")
    public ResponseEntity eliminarForo(@PathVariable Long id) {
        Foro foro = foroRepository.getReferenceById(id);
        foro.desactivarForo();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener registros del foro con ID")
    public ResponseEntity<DatoRespForo> retornaDatosForo(@PathVariable Long id) {
        Foro foro = null;
        var datosForo = new DatoRespForo(foro.getId(), foro.getNombre(), foro.getTipo().toString(),
                new DatosDireccion(foro.getDireccion));
        return ResponseEntity.ok(datosForo);

    }
}
