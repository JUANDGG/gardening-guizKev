package com.guizKev.api.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.* ;

@Entity
@Getter @Setter  @NoArgsConstructor
@Table(name = "cliente")
public class Client {
     @Id
    @Column(name = "codigo_cliente", nullable = false,columnDefinition = "INTEGER")
    private int clientCode;

    @Column(name = "nombre_cliente", nullable = false,columnDefinition ="VARCHAR(50)")
    private String clientName;

    @Column(name = "nombre_contacto", nullable = true,columnDefinition ="VARCHAR(30) DEFAULT NULL")
    private String contactName;


    @Column(name = "apellido_contacto", nullable = true,columnDefinition="VARCHAR(30) DEFAULT NULL")
    private String contactLastName;

    @Column(name = "telefono", nullable = false,columnDefinition="VARCHAR(15)")
    private String phone;

    @Column(name = "fax", nullable = false,columnDefinition="VARCHAR(15)")
    private String fax;

    @Column(name = "linea_direccion1", nullable = false,columnDefinition="VARCHAR(50)")
    private String addressLine1;

    @Column(name = "linea_direccion2", nullable = true,columnDefinition="VARCHAR(50)  DEFAULT NULL")
    private String addressLine2;

    @Column(name = "ciudad", nullable = false,columnDefinition="VARCHAR(50)")
    private String city;

    @Column(name = "region", nullable = true,columnDefinition="VARCHAR(50) DEFAULT NULL")
    private String region;

    @Column(name = "pais", nullable = true,columnDefinition="VARCHAR(50) DEFAULT NULL")
    private String country;

    @Column(name = "codigo_postal", nullable = true,columnDefinition="VARCHAR(10) DEFAULT NULL")
    private String postalCode;


    @Column(name = "limite_credito", nullable = true ,columnDefinition="NUMERIC(15,2) DEFAULT NULL")
    private Double creditLimit;

    @JsonManagedReference 
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payment;

    @JsonManagedReference 
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> order;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "codigo_empleado_rep_ventas",referencedColumnName = "codigo_empleado")
    private Employee employee ;


}
