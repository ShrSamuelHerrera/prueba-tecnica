package com.shr.indtx.pruebatecnicainditex.app.service;

import com.shr.indtx.pruebatecnicainditex.app.client.ProductController;



import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;
import com.shr.indtx.pruebatecnicainditex.app.domain.SimilarProductResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SimilarProductServiceImpl implements SimilarProductService {


    private final ProductController productFeignClient;

    @Autowired
    public SimilarProductServiceImpl(ProductController productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    @Override
    public SimilarProductResponse getSimilarProducts(String productId) {
        List<ProductDetailResponse> products = new LinkedList<>();
        List<String> prodictsIds;
        try {
            prodictsIds = productFeignClient.getSimilarProductsIds(productId);
        } catch (FeignException e) {
            return null;
        }
        for (String id : prodictsIds) {
            try {
                products.add(productFeignClient.getProductDetail(id));
            } catch (Exception ignored) {

            }
        }
        return SimilarProductResponse.builder().products(products).build();


    }


}

