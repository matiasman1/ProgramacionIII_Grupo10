package org.example.entidades;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UnidadMedida {
    private Long id;
    private String denominacion;
}
