
package com.ecommerce.controller;

import com.ecommerce.model.ProductOffer;
import com.ecommerce.service.ProductOfferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.webflux.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ProductOfferControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductOfferService productOfferService;

    @Test
    public void testGetAllProductOffers() {
        when(productOfferService.getAllProductOffers(null)).thenReturn(null); // Mocking the behavior

        webTestClient.get()
            .uri("/api/v1/product-offers")
            .exchange()
            .expectStatus().isOk();
    }

    // More tests can be added here for other endpoints and scenarios
}
