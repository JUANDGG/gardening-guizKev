package com.guizKev.api.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;



@Entity
@Getter @Setter @Builder 
//falta corregir esto entidad
public class Employee {
     @Id
    @Column(name = "codigo_empleado", nullable = false, columnDefinition = "INTEGER")
    private Integer employeeCode;

    @Column(name = "nombre", nullable = false, columnDefinition = "VARCHAR(50)")
    private String firstName;

    @Column(name = "apellido1", nullable = false, columnDefinition = "VARCHAR(50)")
    private String lastName1;

    @Column(name = "apellido2", columnDefinition = "VARCHAR(50)")
    private String lastName2;

    @Column(name = "extension", nullable = false, columnDefinition = "VARCHAR(10)")
    private String extension;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    
    @ManyToOne
    @JoinColumn(name = "codigo_oficina", nullable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe")
    private Employee manager;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> client;


    @Column(name = "puesto", columnDefinition = "VARCHAR(50)")
    private String position;
}
