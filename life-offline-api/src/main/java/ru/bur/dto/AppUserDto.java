package ru.bur.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppUserDto {
    private Long userId;
    private String phoneNumber;
    private String authorizationToken;
    private String firstName;
    private String lastName;
    private LocalDate birthdayDate;
    private Integer age;

}
