package br.com.leadersofts.qikserve.infrastructure.products.controller;

import br.com.leadersofts.qikserve.core.dto.ProductDTO;
import br.com.leadersofts.qikserve.core.usecases.*;
import br.com.leadersofts.qikserve.infrastructure.products.usecases.ApplyIncreaseInfraStructure;
import br.com.leadersofts.qikserve.infrastructure.products.usecases.ApplyPromotionInfraStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ListAvailableProductsUseCase listAvailableProductsService;

    private final AddItemsUseCase addItemService;

    private final ApplyPromotionUseCase promotionService;

    private final ApplyIncreaseUseCase increaseService;

    private final ListCustomerSavingsUseCase listCustomerSavingsService;

    public ProductController(ListAvailableProductsUseCase listAvailableProductsService, AddItemsUseCase addItemService, ApplyPromotionInfraStructure promotionService, ApplyIncreaseInfraStructure increaseService, ApplyPromotionUseCase promotionService1, ApplyIncreaseUseCase increaseService1, ListCustomerSavingsUseCase listCustomerSavingsService) {
        this.listAvailableProductsService = listAvailableProductsService;
        this.addItemService = addItemService;
        this.promotionService = promotionService1;
        this.increaseService = increaseService1;
        this.listCustomerSavingsService = listCustomerSavingsService;
    }

    @GetMapping("/list-available-on-menu")
    public ResponseEntity<List<ProductDTO>> list() {
        var response = listAvailableProductsService.list();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list-customer-savings")
    public ResponseEntity<List<ProductDTO>> listCustomerSavings(@RequestBody Set<String> ids) {
        var response = listCustomerSavingsService.list(ids);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-items")
    public ResponseEntity<List<ProductDTO>> addProduct(@RequestBody List<ProductDTO> products) {
        var response = this.addItemService.addItems(products);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/apply-promotion")
    public ResponseEntity<List<ProductDTO>> applyPromotion(@RequestBody List<ProductDTO> products) {
        var response = this.promotionService.applyPromotion(products);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/apply-increase")
    public ResponseEntity<List<ProductDTO>> applyIncrease(@RequestBody List<ProductDTO> products) {
        var response = this.increaseService.applyIncrease(products);
        return ResponseEntity.ok(response);
    }

}
