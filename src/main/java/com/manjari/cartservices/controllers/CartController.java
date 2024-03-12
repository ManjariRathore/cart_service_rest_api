package com.manjari.cartservices.controllers;

import com.manjari.cartservices.dtos.FakeStoreCartDto;
import com.manjari.cartservices.services.CartServices;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

@RestController
public class CartController {
    private final CartServices cartServices;

    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @GetMapping("/carts")
    public FakeStoreCartDto[] getAllCarts(){
        return cartServices.getAllCarts();
    }
    @GetMapping("/carts/{id}")
    public FakeStoreCartDto getSingleCart(@PathVariable("id") Long id){
        return cartServices.getSingleCart(id);
    }

    @GetMapping("/cart")
    public FakeStoreCartDto[] getInRange(@RequestParam("startdate") String fromDate, @RequestParam("enddate")  String toDate){
        return cartServices.getInRange(fromDate,toDate);
    }

    @GetMapping("/carts/user/{userId}")
    public FakeStoreCartDto getUserCart(@PathVariable("userId") Long userId){
        return cartServices.getUserCart(userId);
    }

    @PostMapping("/carts")
    public FakeStoreCartDto createCart(@RequestBody FakeStoreCartDto cart ){
        return cartServices.createCart(cart);
    }

    @PutMapping ("/carts/{id}")
    public void updateCart(@PathVariable("id") Long id,@RequestBody FakeStoreCartDto  updatedCart){
        FakeStoreCartDto thisCart = getSingleCart(id);
        if(thisCart!=null) cartServices.updateCart(id,updatedCart);
    }

    @DeleteMapping("/carts/{id}")
    public void deleteCart(@PathVariable("id") Long id ){
        cartServices.deleteCart(id);
    }
}
