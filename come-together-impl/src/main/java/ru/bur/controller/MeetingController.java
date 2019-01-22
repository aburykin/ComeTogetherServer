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

    private final Logger log = LoggerFactory.getLogger(MeetingController.class);

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

    @GetMapping("/{meetingId}/participants")
    public List<Long> getMeetingParticipants(@PathVariable(name = "meetingId") Long meetingId) {
        return meetingUserHrefService.findMeetingParticipants(meetingId);
    }

    @GetMapping("/{meetingId}")
    public MeetingDto getMeeting(@PathVariable(name = "meetingId") Long meetingId) {
        return MapperMeetingDto.toDto(meetingService.getMeeting(meetingId));
    }

    @PostMapping
    public MeetingDto createMeeting(@RequestBody MeetingDto meetingDto) {
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

    @PostMapping("/{meetingId}/participants/{appUserId}")
    public void addParticipantToMeeting(@PathVariable(name = "meetingId") Long meetingId,
                                        @PathVariable(name = "appUserId") Long appUserId) {
        meetingUserHrefService.addParticipant(meetingId,appUserId);
    }

}
