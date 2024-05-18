package com.soa.ordenes.infraestructure.persistence;

import com.soa.ordenes.domain.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository <Orden, Long> {
}
