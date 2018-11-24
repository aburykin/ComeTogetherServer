package ru.bur.dto.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * "href": "http://localhost:8080/appUsers"
 */
@Data
public class HrefDto {

    @JsonProperty("href")
    private String href;
}
