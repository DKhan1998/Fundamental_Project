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

    @GetMapping("/")
    public List<Products> getAllAccount(){
        return this.productsService.readProduct();
    }

    @PostMapping("/createAccount")
    public Products createProduct(@RequestBody Products product){
        return this.productsService.createProducts(product);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        return this.productsService.deleteProductById(id);
    }

    @GetMapping("/getAccountById/{id}")
    public Products getProductById(@PathVariable Long id){
        return this.productsService.findProductsById(id);
    }

    @PutMapping("/updateAccount/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products products){
        return this.productsService.updateProducts(id, products);
    }
}
