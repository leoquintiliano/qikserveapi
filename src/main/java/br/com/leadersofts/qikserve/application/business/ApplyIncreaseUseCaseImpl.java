package br.com.leadersofts.qikserve.application.business;

import br.com.leadersofts.qikserve.adapters.ApplyIncreaseAdapter;
import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.core.usecases.ApplyIncreaseUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyIncreaseUseCaseImpl implements ApplyIncreaseUseCase {

    private final ApplyIncreaseAdapter adapter;

    public ApplyIncreaseUseCaseImpl(ApplyIncreaseAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public List<ProductDTO> applyIncrease(List<ProductDTO> products) {
        return adapter.applyIncrease(products);
    }

}
