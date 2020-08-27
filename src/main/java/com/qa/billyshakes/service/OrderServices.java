package com.qa.billyshakes.service;

import com.qa.billyshakes.domain.Orders;
import com.qa.billyshakes.exceptions.error404;
import com.qa.billyshakes.repo.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices {
    private final OrdersRepository oRepo;

    @Autowired
    public OrderServices(OrdersRepository oRepo) {
        this.oRepo = oRepo;
    }

    public List<Orders> readOrders(){
        return this.oRepo.findAll();
    }

    public Orders createOrders(Orders orders){
        return this.oRepo.save(orders);
    }

    public Orders findOrdersById(Long id){
        return this.oRepo.findById(id).orElseThrow(error404::new);
    }

    public Orders updateOrders(Long id, Orders orders){
        Orders update = findOrdersById(id);
//        update.setEmail(orders.getEmail());
//        update.setPassword(orders.getPassword());
//        update.setFirstname(orders.getFirstname());
//        update.setLastname(orders.getLastname());
//        update.setUsername(orders.getUsername());
        return this.oRepo.save(update);
    }

    public Boolean deleteOrdersById(Long id){
        if(!this.oRepo.existsById(id)){
            throw new error404();
        }
        this.oRepo.deleteById(id);
        return this.oRepo.existsById(id);
    }
}
