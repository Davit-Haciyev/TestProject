package example.com.ecomerse2.model.dto;

import example.com.ecomerse2.model.entity.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RetailerDto {

    @NotBlank(message = "Name can't be empty")
    private String name;

    @Email(message = "Email must be correct format")
    @NotBlank(message = "Email can't be empty")
    private String email;


    private Product product;
}
