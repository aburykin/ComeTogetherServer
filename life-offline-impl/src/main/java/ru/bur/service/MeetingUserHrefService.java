package ru.bur.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.domain.db.tables.pojos.MeetingUserHref;
import ru.bur.repository.MeetingUserHrefRepository;
import ru.bur.session.ThreadLocalCurrentUser;

import java.util.List;
import java.util.stream.Collectors;

import static ru.bur.domain.db.Tables.MEETING_USER_HREF;

@Service
public class MeetingUserHrefService {

    @Autowired
    private MeetingUserHrefRepository meetingUserHrefRepository;

    @Autowired
    private DSLContext dslContext;

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

    public void deleteParticipant(Long meetingId, Long appUserId) {
        MeetingUserHref href = dslContext.select()
                .from(MEETING_USER_HREF)
                .where(MEETING_USER_HREF.MEETING_ID.eq(meetingId))
                .and(MEETING_USER_HREF.APP_USER_ID.eq(appUserId))
                .fetchOneInto(MeetingUserHref.class);

        if (href != null && !href.getIsOrganizer()) {
            meetingUserHrefRepository.delete(href);
        }

    }

}