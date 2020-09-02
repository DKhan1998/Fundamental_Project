package com.qa.billyshakes.service;

import com.qa.billyshakes.domain.Products;
import com.qa.billyshakes.dto.ProductsDTO;
import com.qa.billyshakes.exceptions.error404;
import com.qa.billyshakes.repo.ProductsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    private final ProductsRepository pRepo;

    private final ModelMapper mapper;

    @Autowired
    public ProductsService(ProductsRepository pRepo, ModelMapper mapper) {
        this.pRepo = pRepo;
        this.mapper = mapper;
    }

    private ProductsDTO mapToDTO(Products products){
        return this.mapper.map(products,ProductsDTO.class);
    }

    public List<ProductsDTO> readProducts(){
        return this.pRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ProductsDTO createProducts(Products products){
        return this.mapToDTO(this.pRepo.save(products));
    }

    public ProductsDTO findProductsById(Long id){
        return this.mapToDTO(this.pRepo.findById(id)
                .orElseThrow(error404::new));
    }

    public ProductsDTO updateProducts(Long id, Products products){
        Products update = this.pRepo.findById(id)
                .orElseThrow(error404::new);
        update.setTitle(products.getTitle());
        update.setImage(products.getImage());
        update.setDescription(products.getDescription());
        update.setPrice(products.getPrice());
        update.setStock(products.getStock());
        //update.setImage(products.getImage());
        return this.mapToDTO(this.pRepo.save(update));
    }

    public Boolean deleteProductById(Long id){
        if(!this.pRepo.existsById(id)){
            throw new error404();
        }
        this.pRepo.deleteById(id);
        return this.pRepo.existsById(id);
    }
}
