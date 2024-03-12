package com.guizKev.api.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Payment {
  @Id
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Client client;

    @Column(name = "forma_pago", nullable = false, columnDefinition = "VARCHAR(40)")
    private String paymentForm;

    @Id
    @Column(name = "id_transaccion", nullable = false, columnDefinition = "VARCHAR(50)")
    private String transactionId;

    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "total", nullable = false, precision = 15, scale = 2)
    private BigDecimal total;

    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentId implements Serializable {
        private Client client;
        private String transactionId;
    }
}