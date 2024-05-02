package br.com.leadersofts.qikserve.infrastructure.products.service;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.converter.ProductConverter;
import br.com.leadersofts.qikserve.infrastructure.products.mapper.ProductMapper;
import br.com.leadersofts.qikserve.infrastructure.products.pojo.ProductPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ListProductService {

    private RestTemplate restTemplate;

    private UriComponents uriComponents;

    private ProductConverter converter;

    private ProductMapper mapper;

public ListProductService(RestTemplate restTemplate, UriComponents uriComponents, @Qualifier("pojo-converter") ProductConverter converter, ProductMapper mapper) {
        this.restTemplate = restTemplate;
        this.uriComponents = uriComponents;
        this.converter = converter;
        this.mapper = mapper;
    }

    public List<ProductDTO> findAll() {
        ResponseEntity<Collection> entity = this.restTemplate.getForEntity(uriComponents.toUriString(), Collection.class);
        LinkedHashMap result = new LinkedHashMap();
        result.put("key",entity.getBody());
        var productPojos = this.converter.getProductsObject(result);
        return this.getProductsDTO(productPojos);
    }

    public List<ProductDTO> getProductsDTO(List<ProductPojo> productPojos) {
        return this.mapper.toProductDTOFromPojo(productPojos);
    }

}
