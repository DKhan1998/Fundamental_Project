package com.qa.billyshakes.rest;

import com.qa.billyshakes.domain.Products;
import com.qa.billyshakes.dto.ProductsDTO;
import com.qa.billyshakes.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProductController {

    private final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/allProducts")
    public ResponseEntity<List<ProductsDTO>> getAllProducts(){
        return ResponseEntity.ok(this.productsService.readProducts());
    }

    @PostMapping(value = "/createProduct")
    public ResponseEntity<ProductsDTO> createProduct(@RequestBody Products product){
        return new ResponseEntity<>(this.productsService.createProducts(product), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return this.productsService.deleteProductById(id)
                ?  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/getProductById/{id}")
    public ResponseEntity<ProductsDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(this.productsService.findProductsById(id));
    }

    @PutMapping(value = "/updateProduct/{id}")
    public ResponseEntity<ProductsDTO> updateProduct(@PathVariable Long id, @RequestBody Products products){
        return ResponseEntity.ok(this.productsService.updateProducts(id, products));
    }

    public ResponseEntity<ProductsDTO> updateNoteWithPathParam(@PathParam("id") Long id, @RequestBody Products product){
        // localhost:8080/updateNoteWithPathParam?id=1
        return ResponseEntity.ok(this.productsService.updateProducts(id, product));
    }
}
