package com.example.Heredar.entidades;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="diferenciador")

@NoArgsConstructor
@AllArgsConstructor

@Table(name="persona")
public abstract class Persona extends BaseEntidad{

    @Column(name = "nombre")
    protected String nombre;

    @Column(name= "apellido")
    protected String apellido;

    protected int edad;
}
