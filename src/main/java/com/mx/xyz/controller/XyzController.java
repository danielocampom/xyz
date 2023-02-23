package com.mx.xyz.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.xyz.app.XyzApp;
import com.mx.xyz.vo.BuscaIncidenciaRequestVO;
import com.mx.xyz.vo.IncidenciaRequestVO;

@RestController
@RequestMapping("/xyz")
public class XyzController {

	@Autowired
	private XyzApp app;

	@PostMapping("/incidencia")
	public ResponseEntity<?> agregaIncidencia(@RequestBody @Valid IncidenciaRequestVO incidencia) {
		return ResponseEntity.ok(app.agregaIncidencia(incidencia));
	}

	@PutMapping("/incidencia/{idIncidencia}")
	public ResponseEntity<?> terminaIncidencia(@PathVariable("idIncidencia") Long idIncidencia) {
		return ResponseEntity.ok(app.resuelveIncidencia(idIncidencia));
	}

	@PostMapping("/incidencia/buscar")
	public ResponseEntity<?> buscaIncidencia(@RequestBody BuscaIncidenciaRequestVO busca) {
		return ResponseEntity.ok(app.consultaIncidencia(busca));
	}

	@GetMapping("/dashboard")
	public ResponseEntity<?> dashboard() {
		return ResponseEntity.ok(app.consultaDash());
	}

}
