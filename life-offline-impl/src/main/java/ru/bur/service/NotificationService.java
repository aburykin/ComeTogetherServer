package ru.bur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.domain.db.tables.pojos.Notification;
import ru.bur.repository.NotificationsRepository;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationsRepository notificationsRepository;
    @Autowired
    private MeetingUserHrefService meetingUserHrefService;

    private String message = "Встреча была изменена";

    public List<Notification> getAllNotificationsByUser(AppUser appUser) {
        List<Notification> list = notificationsRepository.getAllNotificationsByUser(appUser);
        list.forEach(x -> x.setIsRead(true));
        notificationsRepository.update(list);
        return list;
    }


    public void createNotificationsForMeeting(Long meetingId) {
        List<Long> participants = meetingUserHrefService.findMeetingParticipants(meetingId);
        participants.forEach(appUserId -> {
            createNotification(appUserId, message);
        });
    }

    /**
     * @param appUserId - из класса AppUser
     * @param message
     */
    private void createNotification(Long appUserId, String message) {
        Notification notification = new Notification();
        notification.setAppUserId(appUserId);
        notification.setMessageText(message);
        notification.setIsRead(false);
        notificationsRepository.insert(notification);
    }

}
