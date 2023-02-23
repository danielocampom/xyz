package com.mx.xyz.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EquipoEntity implements Serializable {

	private static final long serialVersionUID = -3195138938789152640L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipo;
	private String nombreEquipo;
	private Date fechaRegistro;
	@ManyToOne
	private OperadorEntity operadorRegistrar;

}
