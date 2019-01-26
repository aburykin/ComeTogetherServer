package ru.bur.repository;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bur.domain.db.tables.daos.MeetingUserHrefDao;

@Repository
public class MeetingUserHrefRepository extends MeetingUserHrefDao {

    @Autowired
    public MeetingUserHrefRepository(Configuration configuration) {
        super(configuration);
    }

}
