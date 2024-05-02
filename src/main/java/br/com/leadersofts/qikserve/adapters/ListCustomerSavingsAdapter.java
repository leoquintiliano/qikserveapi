package br.com.leadersofts.qikserve.adapters;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;

import java.util.List;
import java.util.Set;

public interface ListCustomerSavingsAdapter {

    List<ProductDTO> list(Set<String> customerIds);

}
