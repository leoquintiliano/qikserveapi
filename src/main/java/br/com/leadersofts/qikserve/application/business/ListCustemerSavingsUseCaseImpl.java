package br.com.leadersofts.qikserve.application.business;

import br.com.leadersofts.qikserve.adapters.ListCustomerSavingsAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.core.usecases.ListCustomerSavingsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ListCustemerSavingsUseCaseImpl implements ListCustomerSavingsUseCase {

    ListCustomerSavingsAdapter service;

    public ListCustemerSavingsUseCaseImpl(ListCustomerSavingsAdapter service) {
        this.service = service;
    }

    @Override
    public List<ProductDTO> list(Set<String> customerIds) {
        return service.list(customerIds);
    }

}
