package ru.bur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.domain.db.tables.pojos.Meeting;
import ru.bur.domain.db.tables.pojos.MeetingUserHref;
import ru.bur.repository.MeetingUserHrefRepository;
import ru.bur.session.ThreadLocalCurrentUser;

@Service
public class MeetingUserHrefService {

    @Autowired
    private MeetingUserHrefRepository meetingUserHrefRepository;


    public void createMeetingUserHref(Meeting meeting){
        AppUser appUser = ThreadLocalCurrentUser.getAppUser();

        MeetingUserHref href = new MeetingUserHref();
        href.setMeetingId(meeting.getMeetingId());
        href.setAppUserId(appUser.getAppUserId());
        href.setIsOrganizer(true);
        meetingUserHrefRepository.insert(href);
    }

}
