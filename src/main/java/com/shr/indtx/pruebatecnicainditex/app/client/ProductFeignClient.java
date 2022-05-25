package com.shr.indtx.pruebatecnicainditex.app.client;

import com.shr.indtx.pruebatecnicainditex.app.client.vo.ProductDetailResponseWeb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient(name = "productservice",url = "http://localhost:3001")
public interface ProductFeignClient {

   @GetMapping(value = "product/{productId}/similarids")
    List<String> similarProducts (@PathVariable String productId);

   @GetMapping(value = "product/{productId}")
   ProductDetailResponseWeb getProductDetail(@PathVariable String productId);
}
