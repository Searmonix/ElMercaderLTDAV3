package com.example.ElMercaderLTDA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ElMercaderLTDA.Model.Orders;
import com.example.ElMercaderLTDA.Services.OrderServices;

import java.util.List;

@RestController
@CrossOrigin(origins= "*", methods = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
@RequestMapping("/api/order")
public class OrdersController {
    
    @Autowired
    OrderServices orderServices;

    @GetMapping("/all")
    public List<Orders> getAll() {
        return orderServices.getAll();
    }

    @GetMapping("/{id}")
    public Orders getOrders(@PathVariable int id) {
        return orderServices.getOrders(id);
    }

    @GetMapping("/zone/{zone}")
    public List<Orders> getOrdersByZone(@PathVariable String zone) {
        return orderServices.getOrdersByZone(zone);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders save(@RequestBody Orders orders) {
        return orderServices.save(orders);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders update(@RequestBody Orders orders) {
        return orderServices.update(orders);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        orderServices.delete(id);
    }

}
