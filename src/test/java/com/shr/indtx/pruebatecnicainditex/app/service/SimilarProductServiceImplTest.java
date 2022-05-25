package com.shr.indtx.pruebatecnicainditex.app.service;

import com.shr.indtx.pruebatecnicainditex.app.client.ProductController;
import com.shr.indtx.pruebatecnicainditex.app.domain.ProductDetailResponse;
import com.shr.indtx.pruebatecnicainditex.app.domain.SimilarProductResponse;
import feign.FeignException;
import feign.Request;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimilarProductServiceImplTest {

    ProductController controller = mock(ProductController.class);
    SimilarProductServiceImpl service = new SimilarProductServiceImpl(controller);

    @Test
    void shouldReturnNull() {
        when(controller.getSimilarProductsIds(anyString())).thenThrow(FeignException.class);
            assertNull(service.getSimilarProducts("1"));
    }

    @Test
    void shouldReturnOK() {
        List<String> ids = Arrays.asList("1","2","3");
        when(controller.getSimilarProductsIds(anyString())).thenReturn(ids);
        when(controller.getProductDetail(anyString())).thenReturn(ProductDetailResponse.builder().build());
        assertNotNull(service.getSimilarProducts("1"));
    }

    @Test
    void shouldReturn2Items() {

        List<String> ids = Arrays.asList("1","2","3");
        when(controller.getSimilarProductsIds(anyString())).thenReturn(ids);
        when(controller.getProductDetail("1")).thenReturn(ProductDetailResponse.builder().build());
        when(controller.getProductDetail("2")).thenThrow(FeignException.class);
        when(controller.getProductDetail("3")).thenReturn(ProductDetailResponse.builder().build());
        SimilarProductResponse response =service.getSimilarProducts("1");
        assertEquals(2, response.getProducts().size());
    }

}