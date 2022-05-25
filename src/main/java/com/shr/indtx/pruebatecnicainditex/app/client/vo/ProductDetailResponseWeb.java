package com.shr.indtx.pruebatecnicainditex.app.client.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponseWeb {
    private String id;
    private String name;
    private Double price;
    private Boolean availability;
}
