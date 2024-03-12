package com.manjari.cartservices.services;

import com.manjari.cartservices.dtos.FakeStoreCartDto;
import com.manjari.cartservices.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FakeStoreCartServices implements CartServices{
    private final String url = "https://fakestoreapi.com/carts";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public FakeStoreCartDto[] getAllCarts(){
        return restTemplate.getForObject(
                url,
                FakeStoreCartDto[].class
        );
    }
    @Override
    public FakeStoreCartDto getSingleCart(Long id) {
        return restTemplate.getForObject(
                url + "/" + id,
                FakeStoreCartDto.class
        );
    }


    @Override
    public FakeStoreCartDto getUserCart(Long userId) {
        return restTemplate.getForObject(
                url + "/" + userId,
                FakeStoreCartDto.class
        );
    }

    @Override
    public FakeStoreCartDto createCart(FakeStoreCartDto cart) {
        return restTemplate.postForObject(
                url,cart,FakeStoreCartDto.class
        );
    }

    @Override
    public void updateCart(Long id, FakeStoreCartDto updatedCart) {
        restTemplate.put(
                url+"/"+id,
                updatedCart
        );
    }

    @Override
    public void deleteCart(Long id) {
        restTemplate.delete(url+"/"+id);
    }

    @Override
    public FakeStoreCartDto[] getInRange(String fromDate, String toDate) {
        return  restTemplate.getForObject(
                "https://fakestoreapi.com/carts" + "?startdate=" + fromDate + "&enddate=" + toDate,
                FakeStoreCartDto[].class
        );
    }


}
