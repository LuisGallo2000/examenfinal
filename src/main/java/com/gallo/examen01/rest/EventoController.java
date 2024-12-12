package com.gallo.examen01.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gallo.examen01.dto.EventoDto;
import com.gallo.examen01.entity.Evento;
import com.gallo.examen01.converter.EventoConverter;
import com.gallo.examen01.service.EventoService;
import com.gallo.examen01.util.WrapperResponse;

@RestController
@RequestMapping("/v1/eventos")
public class EventoController {

	@Autowired
	private EventoService service;

	@Autowired
	private EventoConverter converter;

	@GetMapping
	public ResponseEntity<List<EventoDto>> findAll() {
		List<EventoDto> eventos = converter.fromEntity(service.findAll());
		return new WrapperResponse(true, "success", eventos).createResponse(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EventoDto> findById(@PathVariable("id") int id) {
		EventoDto evento = converter.fromEntity(service.findById(id));
		return new WrapperResponse(true, "success", evento).createResponse(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EventoDto> create(@RequestBody EventoDto evento) {
		Evento eventoEntity = converter.fromDTO(evento);
		EventoDto nuevoEvento = converter.fromEntity(service.save(eventoEntity));
		return new WrapperResponse(true, "success", nuevoEvento).createResponse(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EventoDto> update(@PathVariable("id") int id, @RequestBody EventoDto evento) {
		Evento eventoEntity = converter.fromDTO(evento);
		EventoDto eventoActualizado = converter.fromEntity(service.save(eventoEntity));
		return new WrapperResponse(true, "success", eventoActualizado).createResponse(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		service.delete(id);
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}
}
