package br.com.leadersofts.qikserve.core.usecases;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;

public interface AddItemsUseCase {

    List<ProductDTO> addItems(List<ProductDTO> products);

}
