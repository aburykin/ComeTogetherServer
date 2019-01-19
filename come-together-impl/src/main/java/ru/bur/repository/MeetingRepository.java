package ru.bur.repository;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bur.domain.db.tables.daos.MeetingDao;

@Repository
public class MeetingRepository extends MeetingDao {

    @Autowired
    public MeetingRepository(Configuration configuration) {
        super(configuration);
    }

}

