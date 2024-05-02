package br.com.leadersofts.qikserve.infrastructure.products.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Product {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal promotionalPrice;

    @Column
    private BigDecimal additionalPrice;

    @Column
    private BigDecimal increasePercentage;

    @Column
    private BigDecimal promotionPercentage;

}
