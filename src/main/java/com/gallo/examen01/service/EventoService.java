package com.gallo.examen01.service;

import com.gallo.examen01.entity.Evento;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface EventoService {
	public List<Evento> findAll(Pageable page);
	public List<Evento> findAll();
	public List<Evento> findByNombre(String nombre, Pageable page);
	public Evento findById(int id);
	public Evento save(Evento evento);
	public void delete(int id);
}
