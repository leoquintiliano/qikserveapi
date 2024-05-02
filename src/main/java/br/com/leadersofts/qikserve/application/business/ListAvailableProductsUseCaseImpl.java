package br.com.leadersofts.qikserve.application.business;

import br.com.leadersofts.qikserve.adapters.ListAvailableProductsAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.core.usecases.ListAvailableProductsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAvailableProductsUseCaseImpl implements ListAvailableProductsUseCase {

    ListAvailableProductsAdapter service;

    public ListAvailableProductsUseCaseImpl(ListAvailableProductsAdapter service) {
        this.service = service;
    }

    @Override
    public List<ProductDTO> list() {
        return service.list();
    }

}
