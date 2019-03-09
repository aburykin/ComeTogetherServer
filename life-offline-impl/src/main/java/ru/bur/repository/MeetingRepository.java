package ru.bur.repository;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bur.domain.db.Tables;
import ru.bur.domain.db.tables.daos.MeetingDao;
import ru.bur.domain.db.tables.pojos.Meeting;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class MeetingRepository extends MeetingDao {

    @Autowired
    public MeetingRepository(Configuration configuration) {
        super(configuration);
    }

    @Autowired
    private DSLContext dslContext;

    private int AMOUNT_ROWS_FOR_MORE_LOADTING = 10;

    /**
     * @return
     */
    public List<Meeting> getFirstNmeetings() {
     //   Timestamp currentTimeInUtc = Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()).minusHours(3L));
        Timestamp currentTimeInUtc = Timestamp.valueOf(LocalDateTime.now().minusHours(3L));
        return dslContext.selectFrom(Tables.MEETING)
                .where(Tables.MEETING.START_DATE.greaterOrEqual(currentTimeInUtc))
                .orderBy(Tables.MEETING.START_DATE.asc())
                .unionAll(dslContext.selectFrom(Tables.MEETING)
                        .where(Tables.MEETING.START_DATE.lessThan(currentTimeInUtc))
                        .orderBy(Tables.MEETING.START_DATE.desc()))
                .maxRows(AMOUNT_ROWS_FOR_MORE_LOADTING)
                .fetchInto(Meeting.class);
    }

    /**
     * получить список завершенных встреч, отсортированных по дате
     *
     * @param lastMeeting - Начиная с этой записи выбираются следующие N записей;
     * @return
     */
    public List<Meeting> getNextMeetings(@NotNull Meeting lastMeeting) {
        Timestamp currentTimeInUtc = lastMeeting.getStartDate();
        return dslContext.selectFrom(Tables.MEETING)
                .where(Tables.MEETING.START_DATE.greaterOrEqual(currentTimeInUtc))
                .orderBy(Tables.MEETING.START_DATE.asc())
                .maxRows(AMOUNT_ROWS_FOR_MORE_LOADTING)
                .fetchInto(Meeting.class);
    }

}

