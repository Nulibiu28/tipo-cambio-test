package com.desafio.tipocambio.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    private String usuario;
    private String clave;
}
