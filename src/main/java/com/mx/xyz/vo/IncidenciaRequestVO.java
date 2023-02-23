package com.mx.xyz.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaRequestVO implements Serializable {

	private static final long serialVersionUID = 7822153748834372009L;
	@NotNull(message = "idOperador es requerido")
	private Long idOperador;
	@NotNull(message = "idEquipo es requerido")
	private Long idEquipo;

}
