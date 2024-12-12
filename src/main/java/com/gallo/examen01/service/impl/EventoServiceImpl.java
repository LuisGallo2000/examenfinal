package com.gallo.examen01.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gallo.examen01.entity.Evento;
import com.gallo.examen01.exception.GeneralException;
import com.gallo.examen01.exception.NoDataFoundException;
import com.gallo.examen01.exception.ValidateException;
import com.gallo.examen01.repository.EventoRepository;
import com.gallo.examen01.service.EventoService;
import com.gallo.examen01.validator.EventoValidator;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> findAll(Pageable pageable) {
        try {
            return repository.findAll(pageable).toList();
        } catch (Exception e) {
            throw new GeneralException("Error al obtener los eventos", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Evento findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("No existe un evento con el ID: " + id));
    }

    @Override
    @Transactional
    public Evento save(Evento evento) {
        try {
            EventoValidator.save(evento);
            if (evento.getId() == 0) {
                // Nuevo evento
                return repository.save(evento);
            }
            // Editar evento
            Evento existente = repository.findById(evento.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe un evento con el ID: " + evento.getId()));
            existente.setNombre(evento.getNombre());
            existente.setDescripcion(evento.getDescripcion());
            existente.setFechaInicio(evento.getFechaInicio());
            existente.setFechaFin(evento.getFechaFin());
            existente.setCosto(evento.getCosto());
            return repository.save(existente);
        } catch (ValidateException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralException("Error al guardar el evento", e);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Evento evento = repository.findById(id)
                .orElseThrow(() -> new NoDataFoundException("No existe un evento con el ID: " + id));
        repository.delete(evento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Evento> findByNombre(String nombre, Pageable pageable) {
        try {
            return repository.findByNombreContaining(nombre, pageable);
        } catch (Exception e) {
            throw new GeneralException("Error al buscar eventos por nombre", e);
        }
    }
}
