
package com.ecommerce.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfig {

    @Bean
    public CqlSession cqlSession() {
        // Mocking the Cassandra connection using DataStax driver
        // In a real-world scenario, connection details and credentials would be provided
        return CqlSession.builder()
                .withLocalDatacenter("datacenter1")
                .build();
    }
}
