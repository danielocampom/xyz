package com.mx.xyz.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponseVO implements Serializable {

	private static final long serialVersionUID = -402677769819453501L;
	private Integer servicioConsultado;
	private Integer insertados;
	private Integer resueltos;
	private Integer abiertos;

}
