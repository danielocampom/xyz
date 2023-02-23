package com.mx.xyz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.xyz.entity.OperadorEntity;

@Repository
public interface OperadorRepository extends JpaRepository<OperadorEntity, Long> {

}
