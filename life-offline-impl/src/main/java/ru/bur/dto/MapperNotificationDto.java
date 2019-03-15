package ru.bur.dto;

import ru.bur.domain.db.tables.pojos.Notification;

import java.util.ArrayList;
import java.util.List;


public class MapperNotificationDto {

    public static NotificationDto toDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setMessageText(notification.getMessageText());
        dto.setCreateDate(notification.getCreateDate());
        return dto;
    }

    public static List<NotificationDto> toListDto(List<Notification> meeting) {
        List<NotificationDto> dtos = new ArrayList<>();
        meeting.forEach(x -> {
            dtos.add(toDto(x));
        });
        return dtos;
    }
}
