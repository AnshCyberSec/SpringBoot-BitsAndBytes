package com.bitsnbytes.product.mapper;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.entity.Product;
import com.bitsnbytes.product.entity.Category;

public class ProductMapper {

    //entity to DTO
    public static ProductDTO toProductDTO(Product product) {
        if(product == null){
            return null;
        }
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    //DTO to entity
    public  static Product toProductEntitiy(ProductDTO productDTO, Category category){
        if(productDTO == null || category == null){
            return null;
        }
    Product product = new Product();
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setCategory(category);

    return product;
        }
}

