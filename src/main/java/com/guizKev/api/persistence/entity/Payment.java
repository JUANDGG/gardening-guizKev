package com.guizKev.api.persistence.entity;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pago")
@IdClass(PaymentId.class)
@Getter  @Setter @NoArgsConstructor
public class Payment {
   @Id
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Client client;

    @Column(name = "forma_pago", nullable = false, columnDefinition = "VARCHAR(40)")
    private String paymentForm;

    @Id
    @Column(name = "id_transaccion", nullable = false, columnDefinition = "VARCHAR(50)")
    private String transactionId;

    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", nullable = false, columnDefinition = "DECIMAL(15,2)")
    private double total;


  


}