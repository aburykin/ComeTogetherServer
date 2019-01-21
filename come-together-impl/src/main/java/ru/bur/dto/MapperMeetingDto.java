package ru.bur.dto;


import ru.bur.domain.db.tables.pojos.Meeting;

import java.util.ArrayList;
import java.util.List;

public class MapperMeetingDto {

    public static MeetingDto toDto(Meeting meeting) {
        MeetingDto dto = new MeetingDto();
        dto.setMeetingId(meeting.getMeetingId());
        dto.setName(meeting.getName());
        dto.setPlace(meeting.getPlace());
        dto.setDescription(meeting.getDescription());
        return dto;
    }

    public static Meeting toModel(MeetingDto dto) {
        Meeting meeting = new Meeting();
        meeting.setMeetingId(dto.getMeetingId());
        meeting.setName(dto.getName());
        meeting.setPlace(dto.getPlace());
        meeting.setDescription(dto.getDescription());
        return meeting;
    }

    public static List<MeetingDto> toListDto(List<Meeting> meeting) {
        List<MeetingDto> meetingDtos = new ArrayList<>();
        meeting.forEach(x -> {
            meetingDtos.add(toDto(x));
        });
        return meetingDtos;
    }
}
