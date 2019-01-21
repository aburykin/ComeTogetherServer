package ru.bur.dto;

import ru.bur.model.MeetingDetailed;

import java.util.ArrayList;
import java.util.List;

public class MapperMeetingDetailedDto {

    public static MeetingDetailedDto toDto(MeetingDetailed model) {
        MeetingDetailedDto dto = new MeetingDetailedDto();
        dto.setMeetingId(model.getMeetingId());
        dto.setName(model.getName());
        dto.setPlace(model.getPlace());
        dto.setDescription(model.getDescription());

        dto.setUserOwnerId(model.getUserOwnerId());
        return dto;
    }

    public static MeetingDetailed toModel(MeetingDetailedDto dto) {
        MeetingDetailed model = new MeetingDetailed();
        model.setMeetingId(dto.getMeetingId());
        model.setName(dto.getName());
        model.setPlace(dto.getPlace());
        model.setDescription(dto.getDescription());

        model.setUserOwnerId(dto.getUserOwnerId());
        return model;
    }

    public static List<MeetingDetailedDto> toListDto(List<MeetingDetailed> meetingDetaileds) {
        List<MeetingDetailedDto> meetingDtos = new ArrayList<>();
        meetingDetaileds.forEach(x -> {
            meetingDtos.add(toDto(x));
        });
        return meetingDtos;
    }


}
