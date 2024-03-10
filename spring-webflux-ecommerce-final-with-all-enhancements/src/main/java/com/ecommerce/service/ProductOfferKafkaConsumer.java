
package com.ecommerce.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductOfferKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ProductOfferKafkaConsumer.class);

    /**
     * Consumes messages from the product-offer-events Kafka topic and logs them.
     *
     * @param message The consumed message.
     */
    @KafkaListener(topics = "product-offer-events", groupId = "group_id")
    public void consume(String message) {
        logger.info("Consumed message from Kafka: " + message);
    }
}
