package com.shr.indtx.pruebatecnicainditex.app.mother;

import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;

public class ProductDetailResponseMother {

    public static final ProductDetailResponse PRODUCT_DETAIL_RESPONSE = ProductDetailResponse.builder()
            .id("1")
            .name("dress")
            .price(40.99)
            .availability(true)
            .build();


}
