package com.desafio.tipocambio.service.Impl;

import com.desafio.tipocambio.exception.ParameterException;
import com.desafio.tipocambio.repository.TipoCambioRepository;
import com.desafio.tipocambio.service.TipoCambioValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipoCambioValidationServiceImpl implements TipoCambioValidationService {

    @Autowired
    private TipoCambioRepository tipoCambioRepository;
    @Override
    public void validateParametersTipoCambio(Double monto, String monedaOrigen, String monedaDestino) throws RuntimeException {
        if(monto == null || monto == 0.0){
            throw new ParameterException("Se ha ingresado un monto incorrecto");
        }
        if(monedaOrigen == null || monedaOrigen.isEmpty() || monedaDestino == null || monedaDestino.isEmpty() ){
            throw new ParameterException("Tiene que ingresar los parametros para la moneda origen y destino ");
        }


    }
}
