package br.com.leadersofts.qikserve.infrastructure.products.usecases;

import br.com.leadersofts.qikserve.adapters.ListCustomerSavingsAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.infrastructure.products.service.ListCustomerSavingsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ListCustomerSavingsInfraStructure implements ListCustomerSavingsAdapter {

    ListCustomerSavingsService service;

    public ListCustomerSavingsInfraStructure(ListCustomerSavingsService service) {
        this.service = service;
    }

    @Override
    public List<ProductDTO> list(Set<String> customerIds ) {
        return service.findAll(customerIds);
    }
}
