package com.gallo.examen01.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gallo.examen01.entity.Evento;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
	List<Evento> findByNombreContaining(String nombre, Pageable page);
}
