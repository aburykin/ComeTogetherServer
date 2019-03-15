package ru.bur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.dto.MapperNotificationDto;
import ru.bur.dto.NotificationDto;
import ru.bur.service.NotificationService;
import ru.bur.session.ThreadLocalCurrentUser;

import java.util.List;

@RestController
@RequestMapping("/rest/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /**
     * Возвращает список уведомлений для пользователя.
     * Например об изменении места или времени во встрече, в которой он участвует.
     */
    @GetMapping
    public List<NotificationDto> getAllNotificationsByUser() {
        AppUser appUser = ThreadLocalCurrentUser.getAppUser();
        return MapperNotificationDto.toListDto(notificationService.getAllNotificationsByUser(appUser));
    }
}
