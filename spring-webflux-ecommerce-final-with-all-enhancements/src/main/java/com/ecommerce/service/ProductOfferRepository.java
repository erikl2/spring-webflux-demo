
package com.ecommerce.service;

import com.ecommerce.model.ProductOffer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Mocking a Cassandra repository for the ProductOffer entity
@Repository
public interface ProductOfferRepository extends CrudRepository<ProductOffer, String> {
    Optional<ProductOffer> findById(String id);
}
