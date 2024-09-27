package org.example.entidades;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UnidadMedida {

    // Clave primaria para la entidad UnidadMedida
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo que representa el nombre de la unidad de medida
    private String denominacion;
}