package com.qa.billyshakes.rest;

import com.qa.billyshakes.domain.Orders;
import com.qa.billyshakes.dto.OrdersDTO;
import com.qa.billyshakes.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<OrdersDTO>> getAllOrders(){
        return ResponseEntity.ok(this.ordersService.readOrders());
    }

    @PostMapping("/createOrders")
    public ResponseEntity<OrdersDTO> createOrders(@RequestBody Orders orders){
        return new ResponseEntity<>(this.ordersService.createOrders(orders), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteOrders(@PathVariable Long id){
        return this.ordersService.deleteOrdersById(id);
    }

    @GetMapping("/getOrdersById/{id}")
    public ResponseEntity<OrdersDTO> getOrdersById(@PathVariable Long id){
        return ResponseEntity.ok(this.ordersService.findOrdersById(id));
    }

    @PutMapping("/updateOrders/{id}")
    public ResponseEntity<OrdersDTO> updateOrders(@PathVariable Long id, @RequestBody Orders orders){
        return ResponseEntity.ok(this.ordersService.updateOrders(id, orders));
    }
}
