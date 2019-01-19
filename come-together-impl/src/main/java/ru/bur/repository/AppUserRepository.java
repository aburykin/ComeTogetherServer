package ru.bur.repository;

import org.jooq.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bur.domain.db.Tables;
import ru.bur.domain.db.tables.daos.AppUserDao;
import ru.bur.domain.db.tables.pojos.AppUser;

@Repository
public class AppUserRepository extends AppUserDao {

    @Autowired
    public AppUserRepository(Configuration configuration) {
        super(configuration);
    }

    public AppUser findOneByAuthorizationToken(String authorizationToken) {
        return fetchOne(Tables.APP_USER.AUTHORIZATION_TOKEN, authorizationToken);
    }

    public AppUser findOneByPhoneNumber(String phoneNumber) {
        return fetchOne(Tables.APP_USER.PHONE_NUMBER, phoneNumber);
    }
}
