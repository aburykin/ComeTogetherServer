package ru.bur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.dto.MapperMeetingDto;
import ru.bur.dto.MeetingDto;
import ru.bur.service.MeetingService;
import ru.bur.service.MeetingUserHrefService;

import java.util.List;

@RestController
@RequestMapping("/rest/meetings")
public class MeetingController {

    private final static Logger log = LoggerFactory.getLogger(MeetingController.class);

    @Autowired
    private MeetingService meetingService;
    @Autowired

    private MeetingUserHrefService meetingUserHrefService;


    @GetMapping
    public List<MeetingDto> getAllMeetings() {
        return MapperMeetingDto.toListDto(meetingService.findAll());
    }

    @GetMapping("/{meetingId}/owners")
    public List<Long> getMeetingOwners(@PathVariable(name = "meetingId") Long meetingId) {
        return meetingUserHrefService.findMeetingOwners(meetingId);
    }

    @PostMapping
    public MeetingDto saveMeeting(@RequestBody MeetingDto meetingDto) {
        Meeting meeting = MapperMeetingDto.toModel(meetingDto);
        return MapperMeetingDto.toDto(meetingService.create(meeting));
    }
    @PutMapping
    public MeetingDto updateMeeting(@RequestBody MeetingDto meetingDto) {
        Meeting meeting = MapperMeetingDto.toModel(meetingDto);
        return MapperMeetingDto.toDto(meetingService.update(meeting));
    }

    @DeleteMapping("/{meetingId}")
    public void deleteMeeting(@PathVariable(name = "meetingId") Long meetingId) {
        meetingService.deleteMeeting(meetingId);
    }
}
