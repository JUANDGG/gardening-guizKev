package com.guizKev.api.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "pago")
@Getter  @Setter @Builder
public class Payment {
  @Id
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Client client;

    @Column(name = "forma_pago", nullable = false, columnDefinition = "VARCHAR(40)")
    private String paymentForm;

    @Column(name = "id_transaccion", nullable = false, columnDefinition = "VARCHAR(50)")
    private String transactionId;

    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", nullable = false, columnDefinition = "DECIMAL(15,2)")
    private double total;


  


}