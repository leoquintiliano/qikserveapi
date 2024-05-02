package br.com.leadersofts.qikserve.application.business;

import br.com.leadersofts.qikserve.adapters.AddItemsAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.core.usecases.AddItemsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddItemsUseCaseImpl implements AddItemsUseCase {

    AddItemsAdapter service;

    public AddItemsUseCaseImpl(AddItemsAdapter service) {
        this.service = service;
    }

    @Override
    public List<ProductDTO> addItems(List<ProductDTO> products) {
        return this.service.addItems(products);
    }

}
