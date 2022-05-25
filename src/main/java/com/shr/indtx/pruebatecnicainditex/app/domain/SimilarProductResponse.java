package com.shr.indtx.pruebatecnicainditex.app.domain;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SimilarProductResponse {
    List<ProductDetailResponse> products;
}
