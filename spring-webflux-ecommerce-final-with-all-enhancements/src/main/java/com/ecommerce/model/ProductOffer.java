
package com.ecommerce.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import java.util.UUID;

@Data
public class ProductOffer {

    @PrimaryKey
    @ApiModelProperty(notes = "The unique ID of the product offer")
    private UUID id;
    
    @ApiModelProperty(notes = "The title of the product offer")
    private String title;
    
    @ApiModelProperty(notes = "Description of the product offer")
    private String description;
    
    @ApiModelProperty(notes = "Price of the product")
    private Double price;
    
    @ApiModelProperty(notes = "Indicates if the product is hazardous material")
    private boolean hazmat;
    
    // Other attributes, getters, setters, and methods can be added as needed

}
