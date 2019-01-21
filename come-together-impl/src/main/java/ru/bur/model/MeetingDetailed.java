package ru.bur.model;

import lombok.Data;
import ru.bur.domain.db.tables.pojos.Meeting;

@Data
public class MeetingDetailed extends Meeting {

    private Long userOwnerId;

}
