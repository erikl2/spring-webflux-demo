
package com.ecommerce.service;

import com.ecommerce.model.ProductOffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    public void receiveProductOfferFromKafka(ProductOffer productOffer) {
        // Simulating receiving a product offer from a Kafka topic
        LOGGER.info("Simulating receiving ProductOffer with ID {} from Kafka.", productOffer.getId());
    }
}
