package com.bitsnbytes.product.mapper;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.mapper.ProductMapper;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static CategoryDTO tocategoryDTO(Category category){
        if(category == null) return null;

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        if(categoryDTO == null) return null;

        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }
}
