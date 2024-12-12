package com.gallo.examen01.service.impl;

import com.gallo.examen01.entity.Rol;
import com.gallo.examen01.repository.RolRepository;
import com.gallo.examen01.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Rol> findByNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    @Override
    public Rol findById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Rol save(Rol rol) {
        return repository.save(rol);
    }

    @Override
    public void delete(int id) {
        Rol rol = repository.findById(id).orElseThrow();
        repository.delete(rol);
    }
}

