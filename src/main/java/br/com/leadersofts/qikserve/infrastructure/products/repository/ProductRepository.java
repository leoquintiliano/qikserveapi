package br.com.leadersofts.qikserve.infrastructure.products.repository;

import br.com.leadersofts.qikserve.infrastructure.products.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
