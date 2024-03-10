
package com.ecommerce.service;

import com.ecommerce.model.ProductOffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    public void sendProductOfferToKafka(ProductOffer productOffer) {
        // Simulating sending a product offer to a Kafka topic
        LOGGER.info("Simulating sending ProductOffer with ID {} to Kafka.", productOffer.getId());
    }
}
