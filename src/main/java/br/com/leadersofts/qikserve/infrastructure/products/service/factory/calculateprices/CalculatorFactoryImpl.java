package br.com.leadersofts.qikserve.infrastructure.products.service.factory.calculateprices;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.mapper.ProductMapper;
import br.com.leadersofts.qikserve.infrastructure.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CalculatorFactoryImpl implements ICalculatorFactory {


    protected final ProductRepository productRepository;

    protected final ProductMapper mapper;

    public CalculatorFactoryImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> findProductsToCalculate(List<ProductDTO> products) {

        Set<String> productIds = new HashSet();

        for(ProductDTO product : products) {
            productIds.add(product.id());
        }

        return this.productRepository.findAllById(productIds)
                .stream()
                .map(p -> this.mapper.documentToProductDTO(p) )
                .collect(Collectors.toList());
    }

    protected List<ProductDTO> updateProducts(List<ProductDTO> productList, List<ProductDTO> increasedProducts) {

        List<ProductDTO> products = new ArrayList();

        for (ProductDTO productDTO : productList) {

                    increasedProducts
                            .stream()
                            .filter(product -> product.id().equals(productDTO.id()))
                            .map(product -> this.productRepository.save(this.mapper.toProductDocument( this.getNewProductDTO(product)) ) )
                            .map( product -> products.add(this.mapper.documentToProductDTO(product)) )
                            .collect(Collectors.toList());
        }

        return products;
    }

    protected ProductDTO getNewProductDTO(ProductDTO prod) {
        return new ProductDTO(prod.id(),prod.name(),prod.price(), prod.promotionalPrice(),prod.additionalPrice(),prod.increasePercentage(), prod.promotionPercentage());
    }

    protected Float getFloat(BigDecimal value) {
        return value.floatValue();
    }

}
