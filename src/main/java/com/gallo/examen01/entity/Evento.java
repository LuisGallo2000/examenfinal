package com.gallo.examen01.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Entity
@Table(name = "eventos")
@EntityListeners(AuditingEntityListener.class)
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", length = 255, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "fecha_inicio", nullable = false)
	private Date fechaInicio;
	
	@Column(name = "fecha_fin", nullable = false)
	private Date fechaFin;
	
	@Column(name = "costo", nullable = false)
	private Double costo;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
}