package com.guizKev.api.persistence.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;




@Entity
@Getter @Setter @NoArgsConstructor
@IdClass(OrderDetailId.class)
@Table(name = "detalle_pedido")

public class OrderDetail {
    @Id
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "codigo_pedido")
    private Order order ;
    
    @Id
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "codigo_producto")
    private Product product;


    @Column(name = "cantidad",nullable = false,columnDefinition = "INTEGER")
    private int  quantity ;

    @Column(name = "precio_unidad",nullable = false,columnDefinition = "NUMERIC(15,2)")
    private int unitPrice ;

    @Column(name = "numero_linea ",nullable = false,columnDefinition = "SMALLINT")
    private  int lineNumber  ;
    
}
