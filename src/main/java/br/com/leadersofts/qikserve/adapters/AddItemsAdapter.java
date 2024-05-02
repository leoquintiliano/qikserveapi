package br.com.leadersofts.qikserve.adapters;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;

public interface AddItemsAdapter {

    List<ProductDTO> addItems(List<ProductDTO> products);

}
