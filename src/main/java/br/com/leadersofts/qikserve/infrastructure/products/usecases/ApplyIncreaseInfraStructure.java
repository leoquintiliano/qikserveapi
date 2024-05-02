package br.com.leadersofts.qikserve.infrastructure.products.usecases;

import br.com.leadersofts.qikserve.adapters.ApplyIncreaseAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.service.ApplyAdditionalPriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyIncreaseInfraStructure implements ApplyIncreaseAdapter {

    private final ApplyAdditionalPriceService service;

    public ApplyIncreaseInfraStructure(ApplyAdditionalPriceService service) {
        this.service = service;
    }

    @Override
    public List<ProductDTO> applyIncrease(List<ProductDTO> products) {
        return service.getProductsWithIncrease(products);
    }

}
