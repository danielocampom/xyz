package com.mx.xyz.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuscaIncidenciaRequestVO implements Serializable {

	private static final long serialVersionUID = 2014559289105345545L;
	private Long idIncidencia;
	private String fecha;
	private Long idOperador;

}
