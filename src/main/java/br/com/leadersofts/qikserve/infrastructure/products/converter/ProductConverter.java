package br.com.leadersofts.qikserve.infrastructure.products.converter;

import br.com.leadersofts.qikserve.infrastructure.products.pojo.ProductPojo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component("pojo-converter")
public class ProductConverter {

    public List<ProductPojo> getProductsObject(LinkedHashMap entity) {

        var anoVeiculoList = (List) entity.get("key");

        List<ProductPojo> products = new ArrayList();

        StreamSupport.stream(anoVeiculoList.spliterator(), false)
                .map( accumulator -> {
                    var id = ((LinkedHashMap) accumulator).get("id").toString();
                    var name = ((LinkedHashMap) accumulator).get("name").toString();
                    var price = ((LinkedHashMap) accumulator).get("price").toString();
                    var anoVeiculo = new ProductPojo(id,name, new BigDecimal(price));
                    products.add(anoVeiculo);
                    return accumulator;
                })
                .collect(Collectors.toList());

        return products;

    }

}
