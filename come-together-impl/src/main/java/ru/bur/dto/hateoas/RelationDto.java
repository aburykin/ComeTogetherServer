package ru.bur.dto.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * "appUsers": {
 * "href": "http://localhost:8080/appUsers"
 * },
 * "me
 */

@Data
public class RelationDto {

    @JsonProperty("appUsers")
    private HrefDto appUsers;

    @JsonProperty("meetings")
    private HrefDto meetings;

}
