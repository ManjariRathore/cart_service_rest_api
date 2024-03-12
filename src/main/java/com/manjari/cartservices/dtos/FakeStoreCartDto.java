package com.manjari.cartservices.dtos;

import com.manjari.cartservices.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private Date date;
    private Product[] products;
}
