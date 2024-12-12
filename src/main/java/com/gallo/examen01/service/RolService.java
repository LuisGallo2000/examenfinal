package com.gallo.examen01.service;

import com.gallo.examen01.entity.Rol;

import java.util.List;

public interface RolService {
    List<Rol> findAll();
    List<Rol> findByNombre(String nombre);
    Rol findById(int id);
    Rol save(Rol rol);
    void delete(int id);
}
