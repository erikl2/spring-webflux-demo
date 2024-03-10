
package com.ecommerce.service;

import com.ecommerce.model.ProductOffer;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CachingService {

    // Using a HashMap to mock a caching mechanism (like Memcached)
    private final Map<String, ProductOffer> cache = new HashMap<>();

    public ProductOffer getCachedOffer(String id) {
        return cache.get(id);
    }

    public void cacheOffer(ProductOffer productOffer) {
        cache.put(productOffer.getId(), productOffer);
    }

    public void evictOfferFromCache(String id) {
        cache.remove(id);
    }
}
