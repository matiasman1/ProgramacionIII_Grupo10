package org.example.entidades;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder
public class Articulo  {

    // Clave primaria para la entidad Articulo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos que representan los detalles del artículo
    private String denominacion;
    private Double precioVenta;
    private String codigo;

    // Relación One-to-One unidireccional con Imagen (clave foránea es imagen)
    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    // Relación Many-to-One con UnidadMedida
    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private UnidadMedida unidadMedida;
}