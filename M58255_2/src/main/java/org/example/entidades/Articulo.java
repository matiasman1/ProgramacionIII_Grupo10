package org.example.entidades;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Imagen imagen;
    private UnidadMedida unidadMedida;
}


