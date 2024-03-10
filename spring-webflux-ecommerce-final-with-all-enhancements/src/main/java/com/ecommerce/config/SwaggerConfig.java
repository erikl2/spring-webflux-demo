
package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
                
                .apiInfo(new ApiInfoBuilder()
                        .title("E-Commerce Product Offer API")
                        .description("API documentation for the E-Commerce Product Offer service.")
                        .version("1.0.0")
                        .contact(new Contact("E-Commerce Team", "www.ecommerce.com", "support@ecommerce.com"))
                        .build())

                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ecommerce.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
