package com.gallo.examen01.converter;

import org.springframework.stereotype.Component;
import com.gallo.examen01.entity.Evento;
import com.gallo.examen01.dto.EventoDto;

@Component
public class EventoConverter extends AbstractConverter<Evento, EventoDto> {

	@Override
	public EventoDto fromEntity(Evento entity) {
		if(entity == null) return null;
		return EventoDto.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
				.fechaInicio(entity.getFechaInicio().toString())
				.fechaFin(entity.getFechaFin().toString())
				.costo(entity.getCosto())
				.build();
	}

	@Override
	public Evento fromDTO(EventoDto dto) {
		if(dto == null) return null;
		return Evento.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
				.descripcion(dto.getDescripcion())
				.costo(dto.getCosto())
				.build();
	}
}
