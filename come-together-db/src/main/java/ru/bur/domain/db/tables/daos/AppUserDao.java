/*
 * This file is generated by jOOQ.
*/
package ru.bur.domain.db.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import ru.bur.domain.db.tables.AppUser;
import ru.bur.domain.db.tables.records.AppUserRecord;


/**
 * пользователи приложения
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AppUserDao extends DAOImpl<AppUserRecord, ru.bur.domain.db.tables.pojos.AppUser, Long> {

    /**
     * Create a new AppUserDao without any configuration
     */
    public AppUserDao() {
        super(AppUser.APP_USER, ru.bur.domain.db.tables.pojos.AppUser.class);
    }

    /**
     * Create a new AppUserDao with an attached configuration
     */
    public AppUserDao(Configuration configuration) {
        super(AppUser.APP_USER, ru.bur.domain.db.tables.pojos.AppUser.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(ru.bur.domain.db.tables.pojos.AppUser object) {
        return object.getAppUserId();
    }

    /**
     * Fetch records that have <code>app_user_id IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByAppUserId(Long... values) {
        return fetch(AppUser.APP_USER.APP_USER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>app_user_id = value</code>
     */
    public ru.bur.domain.db.tables.pojos.AppUser fetchOneByAppUserId(Long value) {
        return fetchOne(AppUser.APP_USER.APP_USER_ID, value);
    }

    /**
     * Fetch records that have <code>phone_number IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByPhoneNumber(String... values) {
        return fetch(AppUser.APP_USER.PHONE_NUMBER, values);
    }

    /**
     * Fetch records that have <code>authorization_token IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByAuthorizationToken(String... values) {
        return fetch(AppUser.APP_USER.AUTHORIZATION_TOKEN, values);
    }

    /**
     * Fetch records that have <code>first_name IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByFirstName(String... values) {
        return fetch(AppUser.APP_USER.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>last_name IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByLastName(Integer... values) {
        return fetch(AppUser.APP_USER.LAST_NAME, values);
    }

    /**
     * Fetch records that have <code>age IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByAge(Integer... values) {
        return fetch(AppUser.APP_USER.AGE, values);
    }

    /**
     * Fetch records that have <code>birthday_date IN (values)</code>
     */
    public List<ru.bur.domain.db.tables.pojos.AppUser> fetchByBirthdayDate(Timestamp... values) {
        return fetch(AppUser.APP_USER.BIRTHDAY_DATE, values);
    }
}
