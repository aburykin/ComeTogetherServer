package ru.bur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bur.domain.AppUser;
import ru.bur.domain.Meeting;
import ru.bur.dto.MapperMeetingDto;
import ru.bur.dto.MeetingDto;
import ru.bur.repository.MeetingRepository;
import ru.bur.session.ThreadLocalCurrentUser;

import java.util.List;

@RestController
@RequestMapping("/rest/meetings")
public class MeetingController {

    private final static Logger log = LoggerFactory.getLogger(MeetingController.class);

    @Autowired
    private MeetingRepository meetingRepository;

    @GetMapping
    public List<MeetingDto> getAllMeetings() {
        return MapperMeetingDto.toListDto(meetingRepository.findAll());
    }

    @PostMapping
    public MeetingDto createMeeting(@RequestBody MeetingDto meetingDto) {
        AppUser appUser = ThreadLocalCurrentUser.getAppUser();

        Meeting meeting = MapperMeetingDto.toModel(meetingDto);
        Meeting result = meetingRepository.save(meeting);
        return MapperMeetingDto.toDto(result);
    }
}
