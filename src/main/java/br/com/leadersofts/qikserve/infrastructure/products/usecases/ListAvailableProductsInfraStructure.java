package br.com.leadersofts.qikserve.infrastructure.products.usecases;

import br.com.leadersofts.qikserve.adapters.ListAvailableProductsAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.service.ListProductService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAvailableProductsInfraStructure implements ListAvailableProductsAdapter {

    private ListProductService productService;

    public ListAvailableProductsInfraStructure(ListProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<ProductDTO> list() {
        return productService.findAll();
    }


}
