package com.aluracursos.foro.foroAlura.controller;

import com.aluracursos.foro.foroAlura.domain.consulta.usuario.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.aluracursos.foro.foroAlura.domain.consulta.foro.Foro.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Registra un nuevo usuario")
    public ResponseEntity registrar(@RequestBody @Valid DatoRegiUsuario datos, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(datos);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId().toUri());
        return ResponseEntity.created(uri).body(new DatoDetalleUsuario(usuario));
    }

    @GetMapping
    @Operation(summary = "Obtener listado usuarios")
    public ResponseEntity<Page<DatoListUsuario>> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion).map(DatoListUsuario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza info usuarios")
    public ResponseEntity actualizar(@RequestBody @Valid DatoActualUsuario datos) {
        var usuario = repository.getReferenceById(datos.id());
        usuario.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DatoDetalleUsuario(usuario));
    }

}
