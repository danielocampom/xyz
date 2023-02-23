package com.mx.xyz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.xyz.entity.EquipoEntity;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {

}
