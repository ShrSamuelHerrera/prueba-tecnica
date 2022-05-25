package com.shr.indtx.pruebatecnicainditex.app.controllers;

import com.shr.indtx.pruebatecnicainditex.app.domain.SimilarProductResponse;
import com.shr.indtx.pruebatecnicainditex.app.service.SimilarProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class SimilarProductController {
    private final SimilarProductService service;


    @Autowired
    public SimilarProductController(final SimilarProductService service ){
        this.service=service;
    }

    @GetMapping(value = "/{productId}/similar")
    public ResponseEntity<SimilarProductResponse> getSimilarProducts(@PathVariable("productId")String productId){

        SimilarProductResponse response = service.getSimilarProducts(productId);
       return response==null||response.getProducts().isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND):
               new ResponseEntity<>(response,HttpStatus.OK);

    }
}
