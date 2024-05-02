package br.com.leadersofts.qikserve.adapters;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;

public interface ApplyPromotionAdapter {

    List<ProductDTO> applyPromotion(List<ProductDTO> products);

}
