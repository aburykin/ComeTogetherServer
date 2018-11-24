package ru.bur.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(schema = "base_schema",name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="app_user_user_id_seq")
    @SequenceGenerator(name="app_user_user_id_seq", sequenceName="app_user_user_id_seq", allocationSize=1)
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
