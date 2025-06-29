package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.service.ProductService;
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
        name = "Product REST api CRUD Operation",
        description = "Create,Read, Update and Delete Operation for Product REST API"
)

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    //getAllProduct
    @Operation(
            summary = "Fetch all products",
            description = "REST API to fetch all products"
    )
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProducts();
    }

    //getProductById
    @Operation(
            summary = "Fetch  products",
            description = "REST API to fetch all products"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
       return productService.getProductById(id);
    }
    @Operation(
            summary = "Create  products",
            description = "REST API to create  products"
    )
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
       ProductDTO createProduct =  productService.createProduct(productDTO);
       return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }
    //updateProduct
    @Operation(
            summary = "Update  products by product id",
            description = "REST API to fetch all products"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
      return productService.updateProduct(id,productDTO);
    }
    //delete product
    @Operation(
            summary = "Delete  products by product id",
            description = "REST API to delete product by productId"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
