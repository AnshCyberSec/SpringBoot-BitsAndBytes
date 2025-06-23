package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.mapper.CategoryMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;


    //Create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return  CategoryMapper.tocategoryDTO(category);

    }
    //get all Categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::tocategoryDTO).toList();
    }
    //get category by id
    public CategoryDTO getCategoryById(Long id){
       Category category =  categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not Found"));

       return CategoryMapper.tocategoryDTO(category);
    }
    //delete category
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category " + id + " has been deleted!";
    }

}
