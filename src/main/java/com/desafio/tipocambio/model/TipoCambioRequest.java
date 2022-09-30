package com.desafio.tipocambio.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoCambioRequest {
    private Double monto;
    private String monedaOrigen;
    private String monedaDestino;
}
