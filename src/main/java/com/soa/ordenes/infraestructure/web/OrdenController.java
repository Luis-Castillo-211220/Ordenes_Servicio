package com.soa.ordenes.infraestructure.web;

import com.soa.ordenes.application.port.in.OrdenUseCase;
import com.soa.ordenes.domain.model.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenUseCase ordenUseCase;

    @Autowired
    public OrdenController(OrdenUseCase ordenUseCase) {
        this.ordenUseCase = ordenUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
        Orden nuevaOrden = ordenUseCase.crearOrden(orden);
        return ResponseEntity.ok(nuevaOrden);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Orden>> listarOrdenes() {
        List<Orden> ordenes = ordenUseCase.listarOrdenes();
        return ResponseEntity.ok(ordenes);
    }

//    @PutMapping("/update/{id}/estatus")
//    public ResponseEntity<Orden> actualizarEstatusOrden(@PathVariable Long id, @RequestBody String nuevoEstatus) {
//        Orden ordenActualizada = ordenUseCase.actualizarEstatusOrden(id, nuevoEstatus);
//        return ResponseEntity.ok(ordenActualizada);
//    }

    @PutMapping("/update/{id}/estatus")
    public ResponseEntity<Orden> actualizarEstatusOrden(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String nuevoEstatus = body.get("nuevoEstatus");
        Orden ordenActualizada = ordenUseCase.actualizarEstatusOrden(id, nuevoEstatus);
        return ResponseEntity.ok(ordenActualizada);
    }
}
