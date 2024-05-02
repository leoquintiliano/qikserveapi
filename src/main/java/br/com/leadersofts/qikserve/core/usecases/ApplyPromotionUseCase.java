package br.com.leadersofts.qikserve.core.usecases;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;

public interface ApplyPromotionUseCase {

    List<ProductDTO> applyPromotion(List<ProductDTO> products);

}
