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
public class ApplyAdditionalPriceService extends CalculatorFactoryImpl {


    public ApplyAdditionalPriceService(ProductRepository productRepository, ProductMapper mapper) {
        super(productRepository, mapper);
    }

    public List<ProductDTO> getProductsWithIncrease(List<ProductDTO> products) {

        var increasedProducts = this.applyIncrease(products);

        var productList = this.findProductsToCalculate(products);

        var response = this.updateProducts(productList, increasedProducts);

        return response;
    }

    public List<ProductDTO> applyIncrease(List<ProductDTO> productDTOSToBeUpdated) {
        return productDTOSToBeUpdated
                .stream()
                .map( p -> this.increase(p))
                .collect(Collectors.toList());
    }

    private ProductDTO increase(ProductDTO prod) {

        var increasedPrice = (prod.price().longValue() > 0 && prod.increasePercentage().longValue() > 0)
                ? this.getAdditional(prod.increasePercentage(), prod.price().longValue()) : prod.additionalPrice();

        return new ProductDTO(prod.id(),prod.name(),prod.price(),prod.promotionalPrice(), increasedPrice ,prod.increasePercentage(), prod.promotionPercentage());
    }

    private BigDecimal getAdditional(BigDecimal increasedValue, Long currentPrice) {
        var increase = this.getFloat(increasedValue);
        var percent = increase / 100;
        var additional = (currentPrice/10) * percent;

        return BigDecimal.valueOf(currentPrice + additional);
    }
}
