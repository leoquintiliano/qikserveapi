package br.com.leadersofts.qikserve.infrastructure.products.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;

    private BigDecimal price;

    private BigDecimal promotionalPrice;

    private BigDecimal additionalPrice;

    private BigDecimal increasePercentage;

    private BigDecimal promotionPercentage;


}
