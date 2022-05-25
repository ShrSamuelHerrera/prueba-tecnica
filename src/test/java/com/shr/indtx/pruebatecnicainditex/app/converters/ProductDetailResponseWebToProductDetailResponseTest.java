package com.shr.indtx.pruebatecnicainditex.app.converters;

import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;
import org.junit.jupiter.api.Test;

import static com.shr.indtx.pruebatecnicainditex.app.mother.ProductDetailResponseMother.PRODUCT_DETAIL_RESPONSE;
import static com.shr.indtx.pruebatecnicainditex.app.mother.ProductDetailResponseWebMother.PRODUCT_DETAIL_RESPONSE_WEB;
import static org.junit.jupiter.api.Assertions.*;

class ProductDetailResponseWebToProductDetailResponseTest {

    ProductDetailResponseWebToProductDetailResponse converter = new ProductDetailResponseWebToProductDetailResponse();

    @Test
    void shouldConvert() {
        ProductDetailResponse response = converter.convert(PRODUCT_DETAIL_RESPONSE_WEB);
        assertEquals(response, PRODUCT_DETAIL_RESPONSE);
    }


}