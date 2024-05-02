package br.com.leadersofts.qikserve.infrastructure.products.service;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.mapper.ProductMapper;
import br.com.leadersofts.qikserve.infrastructure.products.repository.ProductRepository;
import br.com.leadersofts.qikserve.infrastructure.products.service.factory.calculateprices.CalculatorFactoryImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyPromotionService extends CalculatorFactoryImpl {


    public ApplyPromotionService(ProductRepository productRepository, ProductMapper mapper) {
        super(productRepository, mapper);
    }

    public List<ProductDTO> getProductsWithDiscount(List<ProductDTO> products) {

        var increasedProducts = this.applyPromotion(products);

        var productList = super.findProductsToCalculate(products);

        var response = this.updateProducts(productList, increasedProducts);

        return response;
    }

    public List<ProductDTO> applyPromotion(List<ProductDTO> productDTOSToBeUpdated) {
        return productDTOSToBeUpdated
                .stream()
                .map( p -> this.promote(p))
                .collect(Collectors.toList());
    }

    private ProductDTO promote(ProductDTO prod) {

        var promotionalPrice = (prod.price().longValue() > 0 && prod.promotionPercentage().longValue() > 0)
                ? ( this.getPromotion(prod.promotionPercentage(), prod.price().longValue())  ) : prod.promotionalPrice();

        return new ProductDTO(prod.id(),prod.name(),prod.price(),promotionalPrice,prod.additionalPrice(),prod.increasePercentage(), prod.promotionPercentage());
    }

    private BigDecimal getPromotion(BigDecimal percentageValue, Long currentPrice) {
        var percentage = getFloat(percentageValue);
        var percent = percentage / 100;
       var discount = (currentPrice) * percent;

       return BigDecimal.valueOf(currentPrice - discount);
    }
}
