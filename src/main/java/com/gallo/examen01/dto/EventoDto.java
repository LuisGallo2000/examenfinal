package com.gallo.examen01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoDto {
	private int id;
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private Double costo;
}