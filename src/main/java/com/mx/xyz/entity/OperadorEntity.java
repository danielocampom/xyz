package com.mx.xyz.entity;

import java.io.Serializable;

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
public class OperadorEntity implements Serializable {

	private static final long serialVersionUID = 7589875593320620160L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperador;
	private String nombreOperador;

}
