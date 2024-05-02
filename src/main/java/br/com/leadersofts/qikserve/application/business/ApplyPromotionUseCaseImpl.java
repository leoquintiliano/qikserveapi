package br.com.leadersofts.qikserve.application.business;

import br.com.leadersofts.qikserve.adapters.ApplyPromotionAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.core.usecases.ApplyPromotionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyPromotionUseCaseImpl implements ApplyPromotionUseCase {

    @Autowired
    private ApplyPromotionAdapter adapter;

    @Override
    public List<ProductDTO> applyPromotion(List<ProductDTO> products) {
        return adapter.applyPromotion(products);
    }

}
