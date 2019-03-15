/*
 * This file is generated by jOOQ.
*/
package ru.bur.domain.db;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import ru.bur.domain.db.tables.AppUser;
import ru.bur.domain.db.tables.Meeting;
import ru.bur.domain.db.tables.MeetingUserHref;
import ru.bur.domain.db.tables.Notification;
import ru.bur.domain.db.tables.records.AppUserRecord;
import ru.bur.domain.db.tables.records.MeetingRecord;
import ru.bur.domain.db.tables.records.MeetingUserHrefRecord;
import ru.bur.domain.db.tables.records.NotificationRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>base_schema</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AppUserRecord, Long> IDENTITY_APP_USER = Identities0.IDENTITY_APP_USER;
    public static final Identity<MeetingRecord, Long> IDENTITY_MEETING = Identities0.IDENTITY_MEETING;
    public static final Identity<MeetingUserHrefRecord, Long> IDENTITY_MEETING_USER_HREF = Identities0.IDENTITY_MEETING_USER_HREF;
    public static final Identity<NotificationRecord, Long> IDENTITY_NOTIFICATION = Identities0.IDENTITY_NOTIFICATION;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AppUserRecord> APP_USER_PKEY = UniqueKeys0.APP_USER_PKEY;
    public static final UniqueKey<MeetingRecord> MEETING_PKEY = UniqueKeys0.MEETING_PKEY;
    public static final UniqueKey<MeetingUserHrefRecord> MEETING_USER_HREF_PKEY = UniqueKeys0.MEETING_USER_HREF_PKEY;
    public static final UniqueKey<MeetingUserHrefRecord> MEETING_ID_APP_USER_ID_KEY = UniqueKeys0.MEETING_ID_APP_USER_ID_KEY;
    public static final UniqueKey<NotificationRecord> NOTIFICATION_PKEY = UniqueKeys0.NOTIFICATION_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<MeetingUserHrefRecord, MeetingRecord> MEETING_USER_HREF__MEETING_USER_HREF_MEETING_MEETING_ID_FK = ForeignKeys0.MEETING_USER_HREF__MEETING_USER_HREF_MEETING_MEETING_ID_FK;
    public static final ForeignKey<MeetingUserHrefRecord, AppUserRecord> MEETING_USER_HREF__MEETING_USER_HREF_APP_USER_APP_USER_ID_FK = ForeignKeys0.MEETING_USER_HREF__MEETING_USER_HREF_APP_USER_APP_USER_ID_FK;
    public static final ForeignKey<NotificationRecord, AppUserRecord> NOTIFICATION__NOTIFICATIONS_HREF_APP_USER_ID_FK = ForeignKeys0.NOTIFICATION__NOTIFICATIONS_HREF_APP_USER_ID_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AppUserRecord, Long> IDENTITY_APP_USER = Internal.createIdentity(AppUser.APP_USER, AppUser.APP_USER.APP_USER_ID);
        public static Identity<MeetingRecord, Long> IDENTITY_MEETING = Internal.createIdentity(Meeting.MEETING, Meeting.MEETING.MEETING_ID);
        public static Identity<MeetingUserHrefRecord, Long> IDENTITY_MEETING_USER_HREF = Internal.createIdentity(MeetingUserHref.MEETING_USER_HREF, MeetingUserHref.MEETING_USER_HREF.MEETING_USER_HREF_ID);
        public static Identity<NotificationRecord, Long> IDENTITY_NOTIFICATION = Internal.createIdentity(Notification.NOTIFICATION, Notification.NOTIFICATION.NOTIFICATION_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AppUserRecord> APP_USER_PKEY = Internal.createUniqueKey(AppUser.APP_USER, "app_user_pkey", AppUser.APP_USER.APP_USER_ID);
        public static final UniqueKey<MeetingRecord> MEETING_PKEY = Internal.createUniqueKey(Meeting.MEETING, "meeting_pkey", Meeting.MEETING.MEETING_ID);
        public static final UniqueKey<MeetingUserHrefRecord> MEETING_USER_HREF_PKEY = Internal.createUniqueKey(MeetingUserHref.MEETING_USER_HREF, "meeting_user_href_pkey", MeetingUserHref.MEETING_USER_HREF.MEETING_USER_HREF_ID);
        public static final UniqueKey<MeetingUserHrefRecord> MEETING_ID_APP_USER_ID_KEY = Internal.createUniqueKey(MeetingUserHref.MEETING_USER_HREF, "meeting_id_app_user_id_key", MeetingUserHref.MEETING_USER_HREF.MEETING_ID, MeetingUserHref.MEETING_USER_HREF.APP_USER_ID);
        public static final UniqueKey<NotificationRecord> NOTIFICATION_PKEY = Internal.createUniqueKey(Notification.NOTIFICATION, "notification_pkey", Notification.NOTIFICATION.NOTIFICATION_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<MeetingUserHrefRecord, MeetingRecord> MEETING_USER_HREF__MEETING_USER_HREF_MEETING_MEETING_ID_FK = Internal.createForeignKey(ru.bur.domain.db.Keys.MEETING_PKEY, MeetingUserHref.MEETING_USER_HREF, "meeting_user_href__meeting_user_href_meeting_meeting_id_fk", MeetingUserHref.MEETING_USER_HREF.MEETING_ID);
        public static final ForeignKey<MeetingUserHrefRecord, AppUserRecord> MEETING_USER_HREF__MEETING_USER_HREF_APP_USER_APP_USER_ID_FK = Internal.createForeignKey(ru.bur.domain.db.Keys.APP_USER_PKEY, MeetingUserHref.MEETING_USER_HREF, "meeting_user_href__meeting_user_href_app_user_app_user_id_fk", MeetingUserHref.MEETING_USER_HREF.APP_USER_ID);
        public static final ForeignKey<NotificationRecord, AppUserRecord> NOTIFICATION__NOTIFICATIONS_HREF_APP_USER_ID_FK = Internal.createForeignKey(ru.bur.domain.db.Keys.APP_USER_PKEY, Notification.NOTIFICATION, "notification__notifications_href_app_user_id_fk", Notification.NOTIFICATION.APP_USER_ID);
    }
}
