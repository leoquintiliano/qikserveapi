package br.com.leadersofts.qikserve.infrastructure.products.service.factory.calculateprices;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;

public interface ICalculatorFactory {

    List<ProductDTO> findProductsToCalculate(List<ProductDTO> products);

}
