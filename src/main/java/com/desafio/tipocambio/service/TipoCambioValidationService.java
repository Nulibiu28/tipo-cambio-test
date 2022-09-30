package com.desafio.tipocambio.service;

public interface TipoCambioValidationService {
    void validateParametersTipoCambio(Double monto, String monedaOrigen, String monedaDestino) throws RuntimeException;
}
