package com.guizKev.api.persistence.entity;

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
@Getter @Setter @NoArgsConstructor
@Table(name = "producto")
public class Product {
    @Id
    @JsonBackReference 
    @Column(name = "codigo_producto ",nullable = false,columnDefinition = "VARCHAR(15)")
    private  String productCode;
    
    @Column(name = "nombre  ",nullable = false,columnDefinition = "VARCHAR(70)")
    private String  name ;
    
    @ManyToOne
    @JsonBackReference 
    @JoinColumn(name = "gama")
    private  ProductRange productRange ;

    @Column(name = "dimenciones  ",nullable = true,columnDefinition = "VARCHAR(25)")
    private String dimensions ;

    @Column(name = "proveedor", nullable = true, columnDefinition = "VARCHAR(50) DEFAULT NULL")
    private String supplier ;

    @Column(name = "descripcion",nullable = true,columnDefinition = "TEXT")
    private String description ;


    @Column(name = "cantidad_en_stock ",nullable = false,columnDefinition = "SMALLINT")
    private int quantityInStock ;


    @Column(name = "precio_venta  ",nullable = false,columnDefinition = "NUMERIC(15,2)")
    private double salesPrice  ;


    @Column(name = "precio_proveedor",nullable = true,columnDefinition = "NUMERIC(15,2) DEFAULT NULL")
    private double  supplierPrice ;
    
    @JsonBackReference 
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetail;

}
