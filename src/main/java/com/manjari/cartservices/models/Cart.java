package com.manjari.cartservices.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Cart {
    private Long id;
    private Long userId;
    private Date date;
    private Product[] products;
}
