package com.manjari.cartservices.services;

import com.manjari.cartservices.dtos.FakeStoreCartDto;
import com.manjari.cartservices.models.Cart;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface CartServices {
    FakeStoreCartDto[] getAllCarts();

    FakeStoreCartDto getSingleCart(Long id);

    FakeStoreCartDto getUserCart(Long userId);

    FakeStoreCartDto createCart(FakeStoreCartDto cart);

    void updateCart(Long id, FakeStoreCartDto updatedCart);

    void deleteCart(Long id);

    FakeStoreCartDto[] getInRange(String fromDate, String toDate);
}
