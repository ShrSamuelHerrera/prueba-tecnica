package com.shr.indtx.pruebatecnicainditex.app.converters;

import com.shr.indtx.pruebatecnicainditex.app.client.vo.ProductDetailResponseWeb;
import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailResponseWebToProductDetailResponse implements Converter<ProductDetailResponse, ProductDetailResponseWeb> {

    @Override
    public ProductDetailResponse convert(ProductDetailResponseWeb source) {

        return ProductDetailResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .price(source.getPrice())
                .availability(source.getAvailability())
                .build();
    }


}
