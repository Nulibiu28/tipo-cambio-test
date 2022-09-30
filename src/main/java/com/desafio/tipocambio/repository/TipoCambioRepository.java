package com.desafio.tipocambio.repository;

import com.desafio.tipocambio.entity.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambioEntity, Long> {
    TipoCambioEntity findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
