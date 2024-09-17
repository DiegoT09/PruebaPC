package com.upc.ciudadclase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDTO {

    private String nombre;
    private String departamento;
    private Integer habitantes;
}
