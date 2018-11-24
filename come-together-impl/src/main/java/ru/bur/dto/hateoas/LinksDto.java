package ru.bur.dto.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Sasha on 24.11.2018.
 */

/** Пример
 * {
 "_links": {
 "appUsers": {
 "href": "http://localhost:8080/appUsers"
 },
 "meetings": {
 "href": "http://localhost:8080/meetings"
 },
 "profile": {
 "href": "http://localhost:8080/profile"
 }
 }
 }
 */
@Data
public class LinksDto {

    @JsonProperty("_links")
    private RelationDto relations;

}
