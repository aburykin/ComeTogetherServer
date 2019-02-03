package ru.bur.dto;

import lombok.Data;

@Data
public class MeetingDto {

    private Long meetingId;
    private String name;
    private String place;
    private String description;
    private long startDateTime;

}
