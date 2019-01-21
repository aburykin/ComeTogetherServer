/*
 * This file is generated by jOOQ.
*/
package ru.bur.domain.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ru.bur.domain.db.BaseSchema;
import ru.bur.domain.db.Indexes;
import ru.bur.domain.db.Keys;
import ru.bur.domain.db.tables.records.MeetingUserHrefRecord;


/**
 * Участники встречи
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MeetingUserHref extends TableImpl<MeetingUserHrefRecord> {

    private static final long serialVersionUID = 653079037;

    /**
     * The reference instance of <code>base_schema.meeting_user_href</code>
     */
    public static final MeetingUserHref MEETING_USER_HREF = new MeetingUserHref();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MeetingUserHrefRecord> getRecordType() {
        return MeetingUserHrefRecord.class;
    }

    /**
     * The column <code>base_schema.meeting_user_href.meeting_user_href_id</code>.
     */
    public final TableField<MeetingUserHrefRecord, Long> MEETING_USER_HREF_ID = createField("meeting_user_href_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('base_schema.meeting_user_href_meeting_user_href_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>base_schema.meeting_user_href.meeting_id</code>.
     */
    public final TableField<MeetingUserHrefRecord, Long> MEETING_ID = createField("meeting_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>base_schema.meeting_user_href.app_user_id</code>.
     */
    public final TableField<MeetingUserHrefRecord, Long> APP_USER_ID = createField("app_user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>base_schema.meeting_user_href.is_organizer</code>. Если true, то этот участник является ораганизатором встречи
     */
    public final TableField<MeetingUserHrefRecord, Boolean> IS_ORGANIZER = createField("is_organizer", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "Если true, то этот участник является ораганизатором встречи");

    /**
     * Create a <code>base_schema.meeting_user_href</code> table reference
     */
    public MeetingUserHref() {
        this(DSL.name("meeting_user_href"), null);
    }

    /**
     * Create an aliased <code>base_schema.meeting_user_href</code> table reference
     */
    public MeetingUserHref(String alias) {
        this(DSL.name(alias), MEETING_USER_HREF);
    }

    /**
     * Create an aliased <code>base_schema.meeting_user_href</code> table reference
     */
    public MeetingUserHref(Name alias) {
        this(alias, MEETING_USER_HREF);
    }

    private MeetingUserHref(Name alias, Table<MeetingUserHrefRecord> aliased) {
        this(alias, aliased, null);
    }

    private MeetingUserHref(Name alias, Table<MeetingUserHrefRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "Участники встречи");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return BaseSchema.BASE_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.MEETING_USER_HREF_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MeetingUserHrefRecord, Long> getIdentity() {
        return Keys.IDENTITY_MEETING_USER_HREF;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MeetingUserHrefRecord> getPrimaryKey() {
        return Keys.MEETING_USER_HREF_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MeetingUserHrefRecord>> getKeys() {
        return Arrays.<UniqueKey<MeetingUserHrefRecord>>asList(Keys.MEETING_USER_HREF_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MeetingUserHrefRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MeetingUserHrefRecord, ?>>asList(Keys.MEETING_USER_HREF__MEETING_USER_HREF_MEETING_MEETING_ID_FK, Keys.MEETING_USER_HREF__MEETING_USER_HREF_APP_USER_APP_USER_ID_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeetingUserHref as(String alias) {
        return new MeetingUserHref(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeetingUserHref as(Name alias) {
        return new MeetingUserHref(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MeetingUserHref rename(String name) {
        return new MeetingUserHref(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MeetingUserHref rename(Name name) {
        return new MeetingUserHref(name, null);
    }
}