package br.com.leadersofts.qikserve.core.usecases;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;
import java.util.Set;

public interface ListCustomerSavingsUseCase {

    List<ProductDTO> list(Set<String> customerIds);

}
