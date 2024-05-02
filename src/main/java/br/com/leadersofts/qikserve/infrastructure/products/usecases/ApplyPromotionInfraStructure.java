package br.com.leadersofts.qikserve.infrastructure.products.usecases;

import br.com.leadersofts.qikserve.adapters.ApplyPromotionAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.service.ApplyPromotionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyPromotionInfraStructure implements ApplyPromotionAdapter {

    private final ApplyPromotionService service;

    public ApplyPromotionInfraStructure(ApplyPromotionService service, ApplyPromotionService service1) {
        this.service = service1;
    }

    @Override
    public List<ProductDTO> applyPromotion(List<ProductDTO> products) {
        return service.getProductsWithDiscount(products);
    }

}
