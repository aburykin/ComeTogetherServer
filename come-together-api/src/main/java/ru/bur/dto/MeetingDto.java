package ru.bur.dto;

import lombok.Data;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */
@Data
public class MeetingDto {

    private Long id;
    private String name;
    private String place;

    private String description;

}
