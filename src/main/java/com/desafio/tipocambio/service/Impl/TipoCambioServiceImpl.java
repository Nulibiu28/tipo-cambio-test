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

        tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(tipoOrigen,tipoDestino)
                .ifPresentOrElse(cambio -> {
                    Double montoResultado = montoOrigen * cambio.getTipoCambio();

                    map.put("response", TipoCambioResponse.builder()
                            .monto(montoOrigen)
                            .montoTipoDeCambio(montoResultado)
                            .monedaOrigen(tipoOrigen)
                            .monedaDestino(tipoDestino)
                            .tipoDeCambio(cambio.getTipoCambio())
                            .build());
                }, () -> {
                    map.put("response", "No existe el tipo de cambio especificado");
                });

        return map;
    }

    @Override
    public Map<String, Object> updateTipoCambio(Long idTipo, Double nuevoValor) {
        Map<String,Object> map = new HashMap<>();

        tipoCambioRepository.findById(idTipo).ifPresentOrElse( cambio -> {
            cambio.setTipoCambio(nuevoValor);
            tipoCambioRepository.save(cambio);
            map.put("response", "Se actualizo el tipo de cambio");
        }, () -> {
            map.put("response","No existe el tipo de cambio con el id: "+idTipo);
        });

        return map;
    }
}
