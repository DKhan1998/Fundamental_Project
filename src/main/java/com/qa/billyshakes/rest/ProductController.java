package com.qa.billyshakes.rest;

import com.qa.billyshakes.domain.Products;
import com.qa.billyshakes.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/")
    public List<Products> getAllProducts(){
        return this.productsService.readProduct();
    }

    @PostMapping(value = "/createProduct")
    public Products createProduct(@RequestBody Products product){
        return this.productsService.createProducts(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        return this.productsService.deleteProductById(id);
    }

    @GetMapping(value = "/getProductById/{id}")
    public Products getProductById(@PathVariable Long id){
        return this.productsService.findProductsById(id);
    }

    @PutMapping(value = "/updateProduct/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products products){
        return this.productsService.updateProducts(id, products);
    }
}
