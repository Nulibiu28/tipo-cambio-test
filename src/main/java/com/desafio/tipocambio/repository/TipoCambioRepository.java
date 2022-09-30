package com.desafio.tipocambio.repository;

import com.desafio.tipocambio.entity.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambioEntity, Long> {
    Optional<TipoCambioEntity> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

    Optional<TipoCambioEntity> findById(Long idTipo);
}
