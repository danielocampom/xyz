package com.mx.xyz.app;

import com.mx.xyz.vo.BuscaIncidenciaRequestVO;
import com.mx.xyz.vo.DashboardResponseVO;
import com.mx.xyz.vo.IncidenciaRequestVO;
import com.mx.xyz.vo.IncidenciaResponseVO;

public interface XyzApp {

	public IncidenciaResponseVO agregaIncidencia(IncidenciaRequestVO incidencia);

	public IncidenciaResponseVO resuelveIncidencia(Long idIncidencia);

	public Object consultaIncidencia(BuscaIncidenciaRequestVO busca);

	public DashboardResponseVO consultaDash();

}
