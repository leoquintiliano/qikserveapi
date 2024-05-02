package br.com.leadersofts.qikserve.infrastructure.products.service;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.mapper.ProductMapper;
import br.com.leadersofts.qikserve.infrastructure.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ListCustomerSavingsService {

    private ProductMapper mapper;

    private ProductRepository productRepository;

    public ListCustomerSavingsService(ProductMapper mapper, ProductRepository productRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll( Set<String> customerIds) {

        return this.productRepository.findAllById(customerIds)
                .stream()
                .map(item -> this.mapper.documentToProductDTO(item))
                .collect(Collectors.toList());
    }

}
