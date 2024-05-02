package br.com.leadersofts.qikserve.infrastructure.products.usecases;

import br.com.leadersofts.qikserve.adapters.AddItemsAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import br.com.leadersofts.qikserve.infrastructure.products.mapper.ProductMapper;
import br.com.leadersofts.qikserve.infrastructure.products.service.AddProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddItemsInfraStructure implements AddItemsAdapter {

    private AddProductService service;

    private ProductMapper productMapper;

    public AddItemsInfraStructure(AddProductService service, ProductMapper productMapper) {
        this.service = service;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> addItems(List<ProductDTO> products) {
        return  this.service.addItems(products)
                .stream()
                .map( elem ->  this.productMapper.documentToProductDTO(elem))
                .collect(Collectors.toList());
    }

}
