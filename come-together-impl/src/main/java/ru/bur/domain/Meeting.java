package ru.bur.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */
@Entity
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="meeting_id_seq")
    @SequenceGenerator(name="meeting_id_seq", sequenceName="meeting_id_seq", allocationSize=1)
    private Long id;

    @Column
    private String name;

    @Column
    private String place;

   // @Column
   // private LocalTime localDate;

    @Column
    private String description;
}
