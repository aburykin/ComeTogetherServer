package ru.bur.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */
@Entity
@Data
public class Meeting {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private LocalTime localDate;

    @Column
    private String description;
}
