package ru.bur.repository;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bur.domain.db.Tables;
import ru.bur.domain.db.tables.daos.MeetingDao;
import ru.bur.model.MeetingDetailed;

import java.util.List;


@Repository
public class MeetingRepository extends MeetingDao {

    @Autowired
    public MeetingRepository(Configuration configuration) {
        super(configuration);
    }

    @Autowired
    private DSLContext dslContext;

    /*
    public List<MeetingDetailed> findAllMeetingDetailed() {
        return dslContext.select(
                Tables.MEETING.MEETING_ID,
                Tables.MEETING.NAME,
                Tables.MEETING.PLACE,
                Tables.MEETING.START_DATE,
                Tables.MEETING.DESCRIPTION,
                Tables.MEETING_USER_HREF.APP_USER_ID.as("user_owner_id")
        ).from(Tables.MEETING)
                .join(Tables.MEETING_USER_HREF).on(Tables.MEETING.MEETING_ID.eq(Tables.MEETING_USER_HREF.MEETING_ID))
                .where(Tables.MEETING_USER_HREF.IS_ORGANIZER.eq(true)).fetchInto(MeetingDetailed.class);
    }
    */


}

