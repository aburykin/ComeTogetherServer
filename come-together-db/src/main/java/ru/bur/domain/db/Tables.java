/*
 * This file is generated by jOOQ.
*/
package ru.bur.domain.db;


import javax.annotation.Generated;

import ru.bur.domain.db.tables.AppUser;
import ru.bur.domain.db.tables.Meeting;


/**
 * Convenience access to all tables in base_schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * пользователи приложения
     */
    public static final AppUser APP_USER = ru.bur.domain.db.tables.AppUser.APP_USER;

    /**
     * Встречи
     */
    public static final Meeting MEETING = ru.bur.domain.db.tables.Meeting.MEETING;
}