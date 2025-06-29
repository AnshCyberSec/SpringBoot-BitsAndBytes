package com.bitsnbytes.product.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Category",
        description = "It holds category in formation along with their products"
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
