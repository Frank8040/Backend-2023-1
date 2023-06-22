package devaperu.pe.catalogo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String imagen;
    private Double precio;
    private Integer stock;
    private String detalle;
    private String material;
    private String largo;
    private String ancho;
    private String alto;
    private Estado estado;

    public enum Estado {
        Activo,
        Inactivo
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Category categoria;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        if (fechaCreacion == null) {
            fechaCreacion = now;
        }
        fechaActualizacion = now;
    }
}