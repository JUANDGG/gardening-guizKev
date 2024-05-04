package com.guizKev.api.persistence.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "gama_producto")
public class ProductRange {
    @Id
    @Column(name = "gama" ,nullable = false,columnDefinition = "VARCHAR(50)")
    private String range;
    @Column(name = "descripcion_texto" ,nullable = true,columnDefinition = "TEXT")
    private String descriptionText ;
    @Column(name = "descripcion_html" ,nullable = true,columnDefinition = "TEXT")
    private String descriptionHtml  ;
    @Column(name = "imagen" ,nullable = true,columnDefinition = "VARCHAR(256)")
    private String image ;

    @OneToMany(mappedBy = "productRange", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList ;

}
