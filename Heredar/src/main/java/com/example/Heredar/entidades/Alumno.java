package com.example.Heredar.entidades;

import com.example.Heredar.enumeraciones.Especialidad;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("A")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Alumno extends Persona{
    private int legajo;
    private Especialidad especialidad;

    @Builder
    public Alumno (String nombre, String apellido, int edad, int legajo, Especialidad especialidad){
        super(nombre,apellido,edad);
        this.legajo=legajo;
        this.especialidad=especialidad;
    }
}
