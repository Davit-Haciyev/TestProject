package example.com.ecomerse2.model.dto;

import example.com.ecomerse2.model.entity.Retailer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDto {

    @NotBlank(message = "Name can't be empty")
    private String name;

    @Min(value = 1, message = "Price must be 1<price")
    @NotBlank(message = "Price can't be empty")
    private Double price;


    private Retailer retailer;
}
