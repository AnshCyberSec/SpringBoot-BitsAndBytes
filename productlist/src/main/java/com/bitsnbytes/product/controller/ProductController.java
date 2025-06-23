package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    //getAllProduct
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProducts();
    }

    //getProductById
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
       return productService.getProductById(id);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
       ProductDTO createProduct =  productService.createProduct(productDTO);
       return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }
    //updateProduct
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
      return productService.updateProduct(id,productDTO);
    }
    //delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
