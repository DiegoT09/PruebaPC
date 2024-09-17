package com.upc.ciudadclase.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String departamento;
    private Integer habitantes;

    public Ciudad(String nombre, String departamento, Integer habitantes) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.habitantes = habitantes;
    }


}

