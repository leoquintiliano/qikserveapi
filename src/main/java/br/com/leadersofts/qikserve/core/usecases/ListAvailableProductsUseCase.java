package br.com.leadersofts.qikserve.core.usecases;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;

public interface ListAvailableProductsUseCase {

    List<ProductDTO> list();

}
