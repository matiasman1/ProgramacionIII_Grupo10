package org.example.entidades;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Promocion  {

    // Clave primaria para la entidad Promocion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    // Campos que representan los detalles de una promoción
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;

    // Enum que define el tipo de promoción
    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    // Relación Many-to-Many entre Promocion y Articulos con una tabla intermedia
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(name = "promocion_articulo",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    // Relación One-to-Many unidireccional con Imagen (clave foránea es promoImagen)
    @OneToMany
    @JoinColumn(name = "imagen_id")
    @Builder.Default
    private Set<Imagen> promoImagen = new HashSet<>();
}