
package com.ecommerce.service;

import com.ecommerce.model.ProductOffer;
import com.ecommerce.repository.ProductOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class ProductOfferService {

    @Autowired
    private ProductOfferRepository repository;

    @Cacheable(value = "productOffers")
    public Flux<ProductOffer> getAllProductOffers(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    public Optional<ProductOffer> getOffer(String id) {
        return repository.findById(id);
    }

    @Transactional
    public void createOffer(ProductOffer productOffer) {
        integrateWithBusinessRulesEngine(productOffer);
        repository.save(productOffer);
    }

    @Transactional
    public void updateOffer(String id, ProductOffer productOffer) {
        if (repository.existsById(id)) {
            productOffer.setId(id);
            integrateWithBusinessRulesEngine(productOffer);
        repository.save(productOffer);
        }
    }

    public void deleteOffer(String id) {
        repository.deleteById(id);
    }

    private void integrateWithBusinessRulesEngine(ProductOffer productOffer) {
        // Mocked integration with the business rules engine
        // In a real-world scenario, here we would make an API call or some other form of integration
        // to validate or process the product offer with the business rules engine
    }
