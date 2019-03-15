package ru.bur.repository;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bur.domain.db.Tables;
import ru.bur.domain.db.tables.daos.NotificationDao;
import ru.bur.domain.db.tables.pojos.AppUser;
import ru.bur.domain.db.tables.pojos.Notification;

import java.util.List;

@Repository
public class NotificationsRepository extends NotificationDao {

    @Autowired
    private DSLContext dslContext;

    @Autowired
    public NotificationsRepository(Configuration configuration) {
        super(configuration);
    }

    public List<Notification> getAllNotificationsByUser(AppUser appUser) {
        return dslContext.selectFrom(Tables.NOTIFICATION)
                .where(Tables.NOTIFICATION.APP_USER_ID.eq(appUser.getAppUserId()))
                .orderBy(Tables.NOTIFICATION.CREATE_DATE)
                .fetchInto(Notification.class);

    }
}
