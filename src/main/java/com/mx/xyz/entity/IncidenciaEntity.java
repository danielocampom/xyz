package com.mx.xyz.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mx.xyz.enums.EstadoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IncidenciaEntity implements Serializable {

	private static final long serialVersionUID = 5084158366517499132L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInicidencia;
	private Date fechaIncidencia;
	@ManyToOne
	private OperadorEntity operadorIncidencia;
	@ManyToOne
	private EquipoEntity equipoIncidencia;
	private EstadoEnum estadoIncidencia;

}
