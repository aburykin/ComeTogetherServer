package ru.bur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.dto.MapperMeetingDto;
import ru.bur.dto.MeetingDto;
import ru.bur.service.MeetingService;
import ru.bur.service.MeetingUserHrefService;
import ru.bur.service.NotificationService;
import ru.bur.session.ThreadLocalCurrentUser;

import java.util.List;

@RestController
@RequestMapping("/rest/meetings")
public class MeetingController {

    private final Logger log = LoggerFactory.getLogger(MeetingController.class);

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingUserHrefService meetingUserHrefService;

    /**
     * Возвращает первые N записей для показа первого экрана
     */
    @GetMapping
    public List<MeetingDto> getFirstNmeatings() {
        return MapperMeetingDto.toListDto(meetingService.getFirstNmeetings());
    }

    /**
     * Возращает следующие N встреч, относительно указанной встречи
     */
    @PostMapping("/next")
    public List<MeetingDto> getNextMeetings(@RequestBody MeetingDto lastMeetingDto) {
        List<Meeting> meetings = meetingService.getNextMeetings(MapperMeetingDto.toModel(lastMeetingDto));
        return MapperMeetingDto.toListDto(meetings);
    }


    @GetMapping("/{meetingId}/owners")
    public List<Long> getMeetingOwners(@PathVariable(name = "meetingId") Long meetingId) {
        return meetingUserHrefService.findMeetingOwners(meetingId);
    }

    @GetMapping("/filterByUser")
    public List<MeetingDto> getMeetingsFilteredByUser() {
        AppUser appUser = ThreadLocalCurrentUser.getAppUser();
        return MapperMeetingDto.toListDto(meetingService.getMeetingsFilteredByUser(appUser));
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
        meetingUserHrefService.addParticipant(meetingId, appUserId);
    }

    @DeleteMapping("/{meetingId}/participants/{appUserId}")
    public void deleteParticipantFromMeeting(@PathVariable(name = "meetingId") Long meetingId,
                                             @PathVariable(name = "appUserId") Long appUserId) {
        meetingUserHrefService.deleteParticipant(meetingId, appUserId);
    }

}
