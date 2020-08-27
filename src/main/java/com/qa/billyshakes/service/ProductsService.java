package com.qa.billyshakes.service;

import com.qa.billyshakes.domain.Account;
import com.qa.billyshakes.domain.Products;
import com.qa.billyshakes.exceptions.error404;
import com.qa.billyshakes.repo.AccountRepository;
import com.qa.billyshakes.repo.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository pRepo;

    @Autowired
    public ProductsService(ProductsRepository pRepo) {
        this.pRepo = pRepo;
    }

    public List<Products> readProduct(){
        return this.pRepo.findAll();
    }

    public Products createProducts(Products products){
        return this.pRepo.save(products);
    }

    public Products findProductsById(Long id){
        return this.pRepo.findById(id).orElseThrow(error404::new);
    }

    public Products updateProducts(Long id, Products products){
        Products update = findProductsById(id);
        update.setTitle(products.getTitle());
        update.setPrice(products.getPrice());
        update.setStock(products.getStock());
        //update.setImage(products.getImage());
        return this.pRepo.save(update);
    }

    public Boolean deleteProductById(Long id){
        if(!this.pRepo.existsById(id)){
            throw new error404();
        }
        this.pRepo.deleteById(id);
        return this.pRepo.existsById(id);
    }
}
