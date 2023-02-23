package com.mx.xyz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.xyz.entity.MovimientoEntity;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

	public List<MovimientoEntity> findByTipo(String tipo);

}
