package com.qa.billyshakes.rest;

import com.qa.billyshakes.domain.Orders;
import com.qa.billyshakes.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    private final OrderServices ordersService;

    @Autowired
    public OrdersController(OrderServices ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/allOrders")
    public List<Orders> getAllOrders(){
        return this.ordersService.readOrders();
    }

    @PostMapping("/createOrders")
    public Orders createOrders(@RequestBody Orders orders){
        return this.ordersService.createOrders(orders);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteOrders(@PathVariable Long id){
        return this.ordersService.deleteOrdersById(id);
    }

    @GetMapping("/getOrdersById/{id}")
    public Orders getOrdersById(@PathVariable Long id){
        return this.ordersService.findOrdersById(id);
    }

    @PutMapping("/updateOrders/{id}")
    public Orders updateOrders(@PathVariable Long id, @RequestBody Orders orders){
        return this.ordersService.updateOrders(id, orders);
    }
}
