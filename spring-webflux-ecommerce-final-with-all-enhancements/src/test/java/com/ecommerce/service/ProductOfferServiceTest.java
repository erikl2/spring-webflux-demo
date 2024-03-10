
package com.ecommerce.service;

import com.ecommerce.model.ProductOffer;
import com.ecommerce.repository.ProductOfferRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

public class ProductOfferServiceTest {

    @InjectMocks
    private ProductOfferService productOfferService;

    @Mock
    private ProductOfferRepository productOfferRepository;

    public ProductOfferServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProductOffers() {
        when(productOfferRepository.findAll()).thenReturn(Flux.just(new ProductOffer(), new ProductOffer())); // Mocking the behavior

        productOfferService.getAllProductOffers(null);

        // Assertions can be added to validate the behavior
    }

    // More tests can be added here for other methods and scenarios
}
