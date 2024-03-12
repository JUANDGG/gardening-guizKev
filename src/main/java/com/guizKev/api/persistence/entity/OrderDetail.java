package com.guizKev.api.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


// FALTA ESTA ENTIDAD

@Entity
@Getter @Setter @Builder 
@Table(name = "detalle_pedido")
public class OrderDetail {
    @Id
    @Column(name = "codigo_pedido",nullable = false,columnDefinition = "INTEGER")
    private int orderCode;

    //falta hacer pedido para relacionar esta 
    @Column(name = "codigo_producto",nullable = false,columnDefinition = "VARCHAR(15)")
    private String productCode;

    @Column(name = "cantidad",nullable = false,columnDefinition = "INTEGER")
    private int  quantity ;

    @Column(name = "precio_unidad",nullable = false,columnDefinition = "NUMERIC(15,2)")
    private int unitPrice ;

    @Column(name = "numero_linea ",nullable = false,columnDefinition = "SMALLINT ")
    private  int lineNumber  ;
    
}
