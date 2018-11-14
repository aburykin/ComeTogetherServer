package ru.bur.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
