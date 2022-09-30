package com.desafio.tipocambio.service.Impl;

import com.desafio.tipocambio.entity.TipoCambioEntity;
import com.desafio.tipocambio.model.TipoCambioResponse;
import com.desafio.tipocambio.repository.TipoCambioRepository;
import com.desafio.tipocambio.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @Override
    public Map<String,Object> getTipoDeCambioxTipos(Double montoOrigen, String tipoOrigen, String tipoDestino) {

        Map<String, Object> map = new HashMap<>();

        TipoCambioEntity cambio = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(tipoOrigen,tipoDestino);

        if(cambio != null){
            Double montoResultado = montoOrigen * cambio.getTipoCambio();

            map.put("response", TipoCambioResponse.builder()
                    .monto(montoOrigen)
                    .montoTipoDeCambio(montoResultado)
                    .monedaOrigen(tipoOrigen)
                    .monedaDestino(tipoDestino)
                    .tipoDeCambio(cambio.getTipoCambio())
                    .build());

        }else{
            map.put("response", "No existe el tipo de cambio especificado");
        }

        return map;
    }
}
