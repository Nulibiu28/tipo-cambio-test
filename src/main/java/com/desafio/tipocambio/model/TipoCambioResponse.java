package com.desafio.tipocambio.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoCambioResponse {
    private Double monto;
    private Double montoTipoDeCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoDeCambio;
}
