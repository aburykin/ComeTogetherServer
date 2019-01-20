package ru.bur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.dto.MapperMeetingDto;
import ru.bur.dto.MeetingDto;
import ru.bur.service.MeetingService;

import java.util.List;

@RestController
@RequestMapping("/rest/meetings")
public class MeetingController {

    private final static Logger log = LoggerFactory.getLogger(MeetingController.class);

    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public List<MeetingDto> getAllMeetings() {
        return MapperMeetingDto.toListDto(meetingService.findAll());
    }


    @PostMapping
    public MeetingDto createMeeting(@RequestBody MeetingDto meetingDto) {
        Meeting meeting = MapperMeetingDto.toModel(meetingDto);
        Meeting result = meetingService.create(meeting);
        return MapperMeetingDto.toDto(result);
    }

}
