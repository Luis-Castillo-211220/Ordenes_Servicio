package com.soa.ordenes.application.service;

import com.soa.ordenes.application.port.in.OrdenUseCase;
import com.soa.ordenes.domain.model.Orden;
import com.soa.ordenes.infraestructure.persistence.OrdenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService implements OrdenUseCase {

    private final OrdenRepository ordenRepository;

    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    @Override
    @Transactional
    public Orden crearOrden(Orden orden) {
        // Aquí podrías añadir lógica adicional antes de guardar la orden
        orden.setEstatus("Creado");
        return ordenRepository.save(orden);
    }

    @Override
    @Transactional
    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    @Transactional
    public Orden actualizarEstatusOrden(Long ordenId, String nuevoEstatus) {
        Orden orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + ordenId));
        orden.setEstatus(nuevoEstatus);
        return ordenRepository.save(orden);
    }
}
