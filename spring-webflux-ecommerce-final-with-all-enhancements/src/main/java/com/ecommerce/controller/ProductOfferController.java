
package com.ecommerce.controller;

import com.ecommerce.model.ProductOffer;
import com.ecommerce.service.ProductOfferService;
import com.ecommerce.wrapper.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product-offers")
public class ProductOfferController {

    private static final Logger logger = LoggerFactory.getLogger(ProductOfferController.class);

    @Autowired
    private ProductOfferService productOfferService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProductOffers(Pageable pageable) {
        logger.info("Fetching all product offers");
        return ResponseEntity.ok(new ApiResponse<>(productOfferService.getAllProductOffers(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOffer(@PathVariable String id) {
        logger.info("Fetching product offer with ID: {}", id);
        Optional<ProductOffer> fetchedOffer = productOfferService.getOffer(id);
        if (fetchedOffer.isEmpty()) {
            logger.warn("Attempted to fetch a non-existent offer with ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Product offer not found"));
        }
        return ResponseEntity.ok(new ApiResponse<>(fetchedOffer.get()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createOffer(@Valid @RequestBody ProductOffer productOffer) {
        logger.info("Creating new product offer");
        productOfferService.createOffer(productOffer);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Product offer created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateOffer(@PathVariable String id, @Valid @RequestBody ProductOffer productOffer) {
        logger.info("Updating product offer with ID: {}", id);
        productOfferService.updateOffer(id, productOffer);
        return ResponseEntity.ok(new ApiResponse<>("Product offer updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOffer(@PathVariable String id) {
        logger.info("Deleting product offer with ID: {}", id);
        productOfferService.deleteOffer(id);
        return ResponseEntity.ok(new ApiResponse<>("Product offer deleted successfully"));
    }
}
