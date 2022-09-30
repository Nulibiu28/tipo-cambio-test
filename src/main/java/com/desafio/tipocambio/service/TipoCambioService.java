package com.desafio.tipocambio.service;

import com.desafio.tipocambio.model.TipoCambioResponse;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TipoCambioService {
    Map<String,Object> getTipoDeCambioxTipos(Double monto, String tipoOrigen, String tipoDestino);

    Map<String,Object> updateTipoCambio(Long idTipo, Double nuevoValor);
}
