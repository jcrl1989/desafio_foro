package com.aluracursos.foro.foroAlura.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import jakarta.validation.Valid;

import com.aluracursos.foro.foroAlura.domain.consulta.AgendaConsulta;
import com.aluracursos.foro.foroAlura.domain.consulta.DataAgendaConsulta;

import com.aluracursos.foro.foroAlura.infra.errores.ValidacionIntegridad;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")

public class ConsController {

    @Autowired
    private AgendaConsulta service;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Registra consulta en base de datos",
            description = "",
            tags = {"consulta", "post"})
    public ResponseEntity agendar(@RequestBody @Valid DataAgendaConsulta datos) throws ValidacionIntegridad {
        var response = service.agendar(datos);
        return ResponseEntity.ok(response);
    }
}
