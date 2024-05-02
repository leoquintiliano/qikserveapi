package br.com.leadersofts.qikserve.infrastructure.products.mapper;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.entity.Product;
import br.com.leadersofts.qikserve.infrastructure.products.pojo.ProductPojo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                Objects.isNull(product.getId()) ? "": product.getId() ,
                Objects.isNull(product.getName()) ? "" : product.getName() ,
                Objects.isNull(product.getPrice()) ? BigDecimal.ZERO : product.getPrice(),
                Objects.isNull(product.getPromotionalPrice()) ? BigDecimal.ZERO : product.getPromotionalPrice(),
                Objects.isNull(product.getAdditionalPrice()) ? BigDecimal.ZERO : product.getAdditionalPrice(),
                Objects.isNull(product.getIncreasePercentage()) ? BigDecimal.ZERO : product.getIncreasePercentage(),
                Objects.isNull(product.getPromotionPercentage()) ? BigDecimal.ZERO : product.getPromotionPercentage()
        );
    }

    public Product toProduct(ProductDTO productDTO) {
        return Product.builder()
                .id( Objects.nonNull(productDTO.id()) ? productDTO.id() : "" )
                .name( Objects.nonNull(productDTO.name()) ? productDTO.name() : "" )
                .price( Objects.nonNull(productDTO.price()) ? productDTO.price() : BigDecimal.ZERO )
                .promotionalPrice( Objects.nonNull(productDTO.promotionalPrice()) ? productDTO.promotionalPrice() : BigDecimal.ZERO )
                .additionalPrice( Objects.nonNull(productDTO.price()) ? productDTO.price() : BigDecimal.ZERO)
                .promotionPercentage( Objects.nonNull(productDTO.promotionPercentage()) ? productDTO.promotionPercentage() : BigDecimal.ZERO )
                .increasePercentage( Objects.nonNull(productDTO.increasePercentage()) ? productDTO.increasePercentage() : BigDecimal.ZERO )
                .build();
    }

    public List<ProductDTO> toProductDTOFromPojo(List<ProductPojo> productPojos) {

        List<ProductDTO> products = new ArrayList<>();

        productPojos
                .stream()
                .map( elem -> products.add(this.fromPojoToProductDTO(elem)))
                .collect(Collectors.toList());

        return products;
    }

    private ProductDTO fromPojoToProductDTO(ProductPojo product) {
        return new ProductDTO(product.id(), product.name(), product.price(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public br.com.leadersofts.qikserve.infrastructure.products.domain.Product toProductDocument(ProductDTO productDTO) {
        return br.com.leadersofts.qikserve.infrastructure.products.domain.Product.builder()
                .id( Objects.nonNull(productDTO.id()) ? productDTO.id() : "" )
                .name( Objects.nonNull(productDTO.name()) ? productDTO.name() : "" )
                .price( Objects.nonNull(productDTO.price()) ? productDTO.price() : BigDecimal.ZERO )
                .promotionalPrice( Objects.nonNull(productDTO.promotionalPrice()) ? productDTO.promotionalPrice() : BigDecimal.ZERO )
                .additionalPrice( Objects.nonNull(productDTO.additionalPrice()) ? productDTO.additionalPrice() : BigDecimal.ZERO)
                .promotionPercentage( Objects.nonNull(productDTO.promotionPercentage()) ? productDTO.promotionPercentage() : BigDecimal.ZERO )
                .increasePercentage( Objects.nonNull(productDTO.increasePercentage()) ? productDTO.increasePercentage() : BigDecimal.ZERO )
                .build();
    }

    public ProductDTO documentToProductDTO(br.com.leadersofts.qikserve.infrastructure.products.domain.Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getPromotionalPrice(), product.getAdditionalPrice(),
                product.getIncreasePercentage(), product.getPromotionPercentage());
    }

}
