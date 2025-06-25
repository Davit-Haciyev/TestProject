package example.com.ecomerse2.service;


import example.com.ecomerse2.model.dto.RetailerDto;
import example.com.ecomerse2.model.entity.Product;
import example.com.ecomerse2.model.entity.Retailer;
import example.com.ecomerse2.repository.ProductRepository;
import example.com.ecomerse2.repository.RetailerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailerService {
    private final RetailerRepository retailerRepository;
    private final ProductRepository productRepository;
    public RetailerService(RetailerRepository retailerRepository, ProductRepository productRepository) {
        this.retailerRepository = retailerRepository;
        this.productRepository = productRepository;
    }


    public Retailer createRetailer(RetailerDto retailerDto){
        Retailer ret=new Retailer();
        ret.setName(retailerDto.getName());
        ret.setEmail(retailerDto.getEmail());
        return retailerRepository.save(ret);
    }

    public List<Retailer> findAllRetailers() {
        return retailerRepository.findAll();
    }

    public Retailer findRetailerById(Long id){
        return retailerRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Retailer not found"));
    }

    public void deleteRetailerById(Long id){
        retailerRepository.deleteById(id);
    }

    public Retailer updateRetailer(Long id, RetailerDto retailerDto){
        Retailer ret=findRetailerById(id);
        ret.setName(retailerDto.getName());
        ret.setEmail(retailerDto.getEmail());
        return retailerRepository.save(ret);
    }

    public Retailer addProducts(Long id, List<Product> products){
        Retailer retailer=findRetailerById(id);
        for(Product product:products){
            product.setRetailer(retailer);
        }
        retailer.getProduct().addAll(products);
        return retailerRepository.save(retailer);
    }
    public List<Product> findProductsByRetailerId(Long id){
        return productRepository.findByRetailerId(id);
    }
}
