package com.shr.indtx.pruebatecnicainditex.app.domain;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductDetailResponse {
    private String id;
    private String name;
    private Double price;
    private Boolean availability;
}
