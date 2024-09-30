package org.example.entidades;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Promocion {
    private Long id;
    private String denominacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalTime HoraDesde;
    private LocalTime HoraHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion TipoPromocion;
    private Set<Articulo> articulos = new HashSet<>();
    private Imagen promoImagen;
}
