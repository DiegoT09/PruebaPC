package com.upc.ciudadclase.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cantidad {
    private String departamento;
    private Long habitantes;
}

