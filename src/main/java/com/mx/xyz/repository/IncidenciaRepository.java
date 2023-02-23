package com.mx.xyz.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.xyz.entity.IncidenciaEntity;
import com.mx.xyz.entity.OperadorEntity;
import com.mx.xyz.enums.EstadoEnum;

@Repository
public interface IncidenciaRepository extends JpaRepository<IncidenciaEntity, Long> {

	public List<IncidenciaEntity> findByOperadorIncidencia(OperadorEntity operadorIncidencia);

	public List<IncidenciaEntity> findByFechaIncidenciaBetween(Date inicio, Date fin);

	public List<IncidenciaEntity> findByEstadoIncidencia(EstadoEnum estadoIncidencia);

}
