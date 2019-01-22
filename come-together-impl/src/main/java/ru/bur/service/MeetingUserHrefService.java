package ru.bur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.domain.db.tables.pojos.MeetingUserHref;
import ru.bur.repository.MeetingUserHrefRepository;
import ru.bur.session.ThreadLocalCurrentUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingUserHrefService {

    @Autowired
    private MeetingUserHrefRepository meetingUserHrefRepository;

    public void createMeetingUserHref(Meeting meeting) {
        AppUser appUser = ThreadLocalCurrentUser.getAppUser();
        System.out.println("createMeetingUserHref(): appUser=" + appUser);
        MeetingUserHref href = new MeetingUserHref();
        href.setMeetingId(meeting.getMeetingId());
        href.setAppUserId(appUser.getAppUserId());
        href.setIsOrganizer(true);
        meetingUserHrefRepository.insert(href);
    }

    public List<Long> findMeetingOwners(Long meetingId) {
        return meetingUserHrefRepository.fetchByMeetingId(meetingId).stream()
                .filter(MeetingUserHref::getIsOrganizer)
                .map(MeetingUserHref::getAppUserId)
                .collect(Collectors.toList());
    }

    public List<Long> findMeetingParticipants(Long meetingId) {
        return meetingUserHrefRepository.fetchByMeetingId(meetingId).stream()
                .map(MeetingUserHref::getAppUserId)
                .collect(Collectors.toList());
    }


    public void deleteMeetingUserHref(Long meetingId) {
        meetingUserHrefRepository.delete(meetingUserHrefRepository.fetchByMeetingId(meetingId));
    }

    public void addParticipant(Long meetingId, Long appUserId) {
        List<Long> meetingParticipants = findMeetingParticipants(meetingId);
        if (!meetingParticipants.contains(appUserId)) {
            MeetingUserHref href = new MeetingUserHref();
            href.setMeetingId(meetingId);
            href.setAppUserId(appUserId);
            href.setIsOrganizer(false);
            meetingUserHrefRepository.insert(href);
        }
    }
}
