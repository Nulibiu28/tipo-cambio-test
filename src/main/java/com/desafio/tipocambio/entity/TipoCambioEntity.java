package com.desafio.tipocambio.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tipos",uniqueConstraints={
        @UniqueConstraint(columnNames = {"moneda_origen", "moneda_destino"})
})
public class TipoCambioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moneda_origen")
    private String monedaOrigen;

    @Column(name = "moneda_destino")
    private String monedaDestino;

    @Column(name = "tipo_cambio")
    private Double tipoCambio;
}
