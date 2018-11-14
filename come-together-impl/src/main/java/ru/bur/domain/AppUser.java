package ru.bur.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue
    private Long userId;
    @Column
    private String phoneNumber;
    @Column
    private String authorizationToken;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate birthdayDate;
    @Column
    private Integer age;


}
