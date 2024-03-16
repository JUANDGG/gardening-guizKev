package com.guizKev.api.persistence.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pedido")
@Getter @Setter @NoArgsConstructor
public class Order {
     @Id
    @Column(name = "codigo_pedido", nullable = false,columnDefinition = "INTEGER")
    private int orderCode;

    @Column(name = "fecha_pedido", nullable = false,columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "fecha_esperada", nullable = false,columnDefinition = "DATE")
    private Date expectedDate;

    @Column(name = "fecha_entrega", nullable = true,columnDefinition = "DATE DEFAULT NULL")
    private Date deliveryDate;

    @Column(name = "estado", nullable = false ,columnDefinition = "VARCHAR(15)")
    private String state;

    @Column(name = "comentarios", nullable = true,columnDefinition = "TEXT")
    private String comments;


    @JsonBackReference 
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Client client;

    @JsonBackReference 
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetail; 
}
