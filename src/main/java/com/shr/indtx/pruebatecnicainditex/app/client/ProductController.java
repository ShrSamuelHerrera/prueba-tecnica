package com.shr.indtx.pruebatecnicainditex.app.client;


import com.shr.indtx.pruebatecnicainditex.app.converters.ProductDetailResponseWebToProductDetailResponse;

import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductController {


    private final ProductFeignClient productFeignClient;
    private final ProductDetailResponseWebToProductDetailResponse converter;

    @Autowired
    public ProductController(ProductFeignClient productFeignClient, ProductDetailResponseWebToProductDetailResponse converter) {
        this.productFeignClient = productFeignClient;
        this.converter = converter;
    }

    @GetMapping("/product/{productId}")
    public List<String> getSimilarProductsIds(@PathVariable("productId") String productId) {
        return productFeignClient.similarProducts(productId);
    }

    @GetMapping("")
    public ProductDetailResponse getProductDetail(@PathVariable("productId") String productId) {

        return converter.convert(productFeignClient.getProductDetail(productId));
    }
}
