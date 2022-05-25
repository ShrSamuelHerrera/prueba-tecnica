package com.shr.indtx.pruebatecnicainditex.app.service;

import com.shr.indtx.pruebatecnicainditex.app.domain.SimilarProductResponse;

public interface SimilarProductService {

    SimilarProductResponse getSimilarProducts(String productId);
}
