package com.sv.stayGo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "hospedajes")
public class Hospedaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;
    private String destino;
    private String servicio;
    private Double precio;
    private String direccion;
    private Integer capacidad;
    private Boolean disponible;

    @Column(name = "fecha_publicacion")
    private Timestamp fechaPublicacion;

    @ManyToMany
    @JoinTable(
        name = "hospedajes_imagenes",
        joinColumns = @JoinColumn(name = "id_hospedaje"),
        inverseJoinColumns = @JoinColumn(name = "id_imagen")
    )
    private List<Imagen> imagenes;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }

    public Timestamp getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(Timestamp fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public List<Imagen> getImagenes() { return imagenes; }
    public void setImagenes(List<Imagen> imagenes) { this.imagenes = imagenes; }
}
