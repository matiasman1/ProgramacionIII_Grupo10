package org.example.entidades;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Imagen {
    private Long id;
    private String denominacion;
}
