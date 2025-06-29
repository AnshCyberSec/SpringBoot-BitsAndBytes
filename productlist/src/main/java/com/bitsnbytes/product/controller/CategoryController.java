package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.exception.CategoryAlreadyExistsException;
import com.bitsnbytes.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Category REST api CRUD Operation",
        description = "Create,Read, Update and Delete Operation for Category REST API"
)

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    //get all Categories
    @Operation(
            summary = "Fetch all Categories",
            description = "REST API to fetch categories along with their products"
    )
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
       return categoryService.getAllCategories();
    }

    @Operation(
            summary = "Create category",
            description = "REST API to create category"
    )
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){

            CategoryDTO savedCategory =  categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

//        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //get Category by id
    @Operation(
            summary = "Fetch all Categories",
            description = "REST API to fetch all categoryies"
    )
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }
    //delete Category
    @Operation(
            summary = "Delete all CategoryId",
            description = "REST API to delete category by categoryOd"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
