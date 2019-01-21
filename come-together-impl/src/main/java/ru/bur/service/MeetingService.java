package ru.bur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.repository.MeetingRepository;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private MeetingUserHrefService meetingUserHrefService;

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    public Meeting create(Meeting meeting) {
        meetingRepository.insert(meeting);
        meetingUserHrefService.createMeetingUserHref(meeting);
        return meeting;
    }

    public void deleteMeeting(Long meetingId) {
        meetingUserHrefService.deleteMeetingUserHref(meetingId);
        meetingRepository.deleteById(meetingId);
    }

}
