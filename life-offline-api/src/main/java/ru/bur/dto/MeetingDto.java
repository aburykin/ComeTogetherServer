package ru.bur.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */
@Data
public class MeetingDto {

    private Long meetingId;
    private String name;
    private String place;
    private String description;
    private Timestamp startDate;

}
