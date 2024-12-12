package com.gallo.examen01.rest;

import com.gallo.examen01.entity.Rol;
import com.gallo.examen01.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    @Autowired
    private RolService service;

    @GetMapping
    public ResponseEntity<List<Rol>> findAll() {
        List<Rol> roles = service.findAll();
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        Rol registro = service.save(rol);
        return ResponseEntity.ok(registro);
    }
}
