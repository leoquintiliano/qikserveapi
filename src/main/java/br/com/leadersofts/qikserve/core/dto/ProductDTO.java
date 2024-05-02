package br.com.leadersofts.qikserve.core.dto;

import java.math.BigDecimal;

public record ProductDTO(String id, String name, BigDecimal price,
                         BigDecimal promotionalPrice, BigDecimal additionalPrice,
                         BigDecimal increasePercentage, BigDecimal promotionPercentage) {
}
