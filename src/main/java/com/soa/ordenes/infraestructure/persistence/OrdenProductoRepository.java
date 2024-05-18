package com.soa.ordenes.infraestructure.persistence;

import com.soa.ordenes.domain.model.OrdenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenProductoRepository extends JpaRepository <OrdenProducto, Long> {
}
