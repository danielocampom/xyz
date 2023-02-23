package com.mx.xyz.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MovimientoEntity implements Serializable {

	private static final long serialVersionUID = -5096632517040574187L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;
	private String tipo;
	private Date date;

}
