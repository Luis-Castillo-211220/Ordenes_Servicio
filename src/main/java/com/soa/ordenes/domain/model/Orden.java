package com.soa.ordenes.domain.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;

    @Column
    private Double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column
    private String estatus;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrdenProducto> productos = new HashSet<>();

    // Constructor, Getters and Setters
    public Orden() {
        this.estatus = "Creado";
    }

    // Métodos para añadir productos a la orden
    public void addProducto(OrdenProducto producto) {
        productos.add(producto);
        producto.setOrden(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Set<OrdenProducto> getProductos() {
        return productos;
    }

    public void setProductos(Set<OrdenProducto> productos) {
        this.productos = productos;
    }
}
