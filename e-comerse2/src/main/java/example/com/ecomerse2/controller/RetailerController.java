package example.com.ecomerse2.controller;

import example.com.ecomerse2.model.dto.RetailerDto;
import example.com.ecomerse2.model.entity.Product;
import example.com.ecomerse2.model.entity.Retailer;
import example.com.ecomerse2.service.RetailerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retailers")
@RequiredArgsConstructor
@Validated
public class RetailerController {

    private final RetailerService retailerService;

    @PostMapping
    public ResponseEntity<Retailer> create(@RequestBody @Valid RetailerDto retailerDto) {
        return ResponseEntity.ok(retailerService.createRetailer(retailerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retailer> update(@PathVariable Long id, @RequestBody @Valid RetailerDto retailerDto) {
        return ResponseEntity.ok(retailerService.updateRetailer(id, retailerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        retailerService.deleteRetailerById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Retailer> getAll() {
        return retailerService.findAllRetailers();
    }

    @GetMapping("/{id}")
    public Retailer getById(@PathVariable Long id) {
        return retailerService.findRetailerById(id);
    }

    @PutMapping("/{id}/products")
    public ResponseEntity<Retailer> addProducts(@PathVariable Long id, @RequestBody @Valid List<Product> products) {
        return ResponseEntity.ok(retailerService.addProducts(id, products));
    }

    @GetMapping("/{id}/products")
    public List<Product> getRetailerProducts(@PathVariable Long id) {
        return retailerService.findProductsByRetailerId(id);
    }
}

