package com.shr.indtx.pruebatecnicainditex.app.mother;

import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;
import com.shr.indtx.pruebatecnicainditex.app.domain.SimilarProductResponse;


import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class SimilarProductResponseMother {
    public static final SimilarProductResponse SIMILAR_PRODUCT_WITH_PRODUCTS = SimilarProductResponse.builder().products(generateProducts()).build();
    public static final SimilarProductResponse SIMILAR_PRODUCT_WITHOUT_PRODUCTS = SimilarProductResponse.builder().products(new LinkedList<>()).build();

    private static List<ProductDetailResponse> generateProducts() {
        return asList(ProductDetailResponse.builder()
                .id("1")
                .name("dress")
                .price(40.99)
                .availability(false)
                .build());
    }

}
