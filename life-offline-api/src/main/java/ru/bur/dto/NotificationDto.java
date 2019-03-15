package ru.bur.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NotificationDto {
    private String messageText;
    private Timestamp createDate;
}
