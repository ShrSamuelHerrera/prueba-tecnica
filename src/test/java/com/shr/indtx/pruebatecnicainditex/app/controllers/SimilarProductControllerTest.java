package com.shr.indtx.pruebatecnicainditex.app.controllers;

import com.shr.indtx.pruebatecnicainditex.app.domain.SimilarProductResponse;
import com.shr.indtx.pruebatecnicainditex.app.service.SimilarProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.shr.indtx.pruebatecnicainditex.app.mother.SimilarProductResponseMother.SIMILAR_PRODUCT_WITHOUT_PRODUCTS;
import static com.shr.indtx.pruebatecnicainditex.app.mother.SimilarProductResponseMother.SIMILAR_PRODUCT_WITH_PRODUCTS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimilarProductControllerTest {


   private final SimilarProductService service =  mock(SimilarProductService.class);
   private final SimilarProductController controller = new SimilarProductController(service);

    @Test
    void shouldReturnOK()
    {
        when(service.getSimilarProducts(anyString())).thenReturn(SIMILAR_PRODUCT_WITH_PRODUCTS);
        ResponseEntity<SimilarProductResponse>response = controller.getSimilarProducts("1");
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    void shouldReturnKO()
    {
        when(service.getSimilarProducts(anyString())).thenReturn(SIMILAR_PRODUCT_WITHOUT_PRODUCTS);
        ResponseEntity<SimilarProductResponse>response = controller.getSimilarProducts("1");
        assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    void shouldReturnKO2()
    {
        when(service.getSimilarProducts(anyString())).thenReturn(null);
        ResponseEntity<SimilarProductResponse>response = controller.getSimilarProducts("1");
        assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

}