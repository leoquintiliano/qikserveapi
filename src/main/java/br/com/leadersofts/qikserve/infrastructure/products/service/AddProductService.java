package br.com.leadersofts.qikserve.infrastructure.products.service;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.domain.Product;
import br.com.leadersofts.qikserve.infrastructure.products.mapper.ProductMapper;
import br.com.leadersofts.qikserve.infrastructure.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddProductService {

    ProductRepository productRepository;

    ProductMapper mapper;

    public AddProductService(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<Product> addItems(List<ProductDTO> products) {
        return products
                .stream()
                .map(elem -> this.productRepository.save(mapper.toProductDocument(elem)))
                .collect(Collectors.toList());
    }

}
