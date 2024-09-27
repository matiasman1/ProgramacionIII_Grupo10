package com.example.Heredar.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@MappedSuperclass
@Data //Getters and Setters
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntidad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
