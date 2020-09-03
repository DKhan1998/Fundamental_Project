package com.qa.billyshakes.service;

import com.qa.billyshakes.domain.Orders;
import com.qa.billyshakes.dto.OrdersDTO;
import com.qa.billyshakes.exceptions.error404;
import com.qa.billyshakes.repo.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServices {
    private final OrdersRepository oRepo;

    private final ModelMapper mapper;

    @Autowired
    public OrderServices(OrdersRepository oRepo, ModelMapper mapper) {
        this.oRepo = oRepo;
        this.mapper = mapper;
    }

    public OrdersDTO mapToDTO(Orders orders){
        return this.mapper.map(orders, OrdersDTO.class);
    }

    public List<OrdersDTO> readOrders(){
        return this.oRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public OrdersDTO createOrders(Orders orders){
        return this.mapToDTO(this.oRepo.save(orders));
    }

    public OrdersDTO findOrdersById(Long id){
        return this.mapToDTO(this.oRepo.findById(id).orElseThrow(error404::new));
    }

    public OrdersDTO updateOrders(Long id, Orders orders){
        Orders update = this.oRepo.findById(id).orElseThrow(error404::new);
        update.setOrderDate(orders.getOrderDate());
        update.setStatus(orders.getStatus());
        update.setQuantity(orders.getQuantity());
        update.setOverallPrice(orders.getOverallPrice());
        update.setProducts(orders.getProducts());
        return this.mapToDTO(this.oRepo.save(update));
    }

    public Boolean deleteOrdersById(Long id){
        if(!this.oRepo.existsById(id)){
            throw new error404();
        }
        this.oRepo.deleteById(id);
        return this.oRepo.existsById(id);
    }
}
