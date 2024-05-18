package com.soa.ordenes.application.port.in;

import com.soa.ordenes.domain.model.Orden;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrdenUseCase {
    Orden crearOrden(Orden orden);
    List<Orden> listarOrdenes();
    Orden actualizarEstatusOrden(Long ordenId, String nuevoEstatus);
}
