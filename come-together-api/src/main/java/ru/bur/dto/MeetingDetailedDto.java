package ru.bur.dto;

import lombok.Data;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */
@Data
public class MeetingDetailedDto {

    private MeetingDto meeting;
    private String description;

}
