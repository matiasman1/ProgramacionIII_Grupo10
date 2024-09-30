package com.example.Heredar.entidades;

import com.example.Heredar.enumeraciones.Titulos;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("P")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Profesor extends Persona{

    @NonNull
    @Column(name = "cant_hijos")
    private int cantHijos;

    @NonNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @NonNull
    @Column(name = "sueldo",precision = 10, scale=2)
    private BigDecimal sueldo;

    private Titulos titulo;

    @Builder
    public Profesor (String nombre,String apellido,int edad, int cantHijos, Date fechaIngreso, BigDecimal sueldo, Titulos titulo){
        super(nombre,apellido,edad);
        this.cantHijos=cantHijos;
        this.fechaIngreso=fechaIngreso;
        this.sueldo=sueldo;
        this.titulo=titulo;
    }

}
