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
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;

    // Assuming 'Articulo' is linked with this entity
    @OneToOne(mappedBy = "imagen")  // Mapping to the 'Articulo' entity
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
}