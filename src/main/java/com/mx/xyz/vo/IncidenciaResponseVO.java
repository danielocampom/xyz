package com.mx.xyz.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidenciaResponseVO implements Serializable {

	private static final long serialVersionUID = 4841948697026802024L;
	private Long id;
	private Date fecha;
	private String estado;
	private String operador;
	private String equipo;
	private Long idOperador;
	private Long idEquipo;

}
