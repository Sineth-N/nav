package com.d2s2.sinethn.nav.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.d2s2.sinethn.nav.Message;

/**
 * Created by Sineth N on 8/10/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TASKS_TABLE = "TASKS";
    public static final String DATABASE_NAME = "NotifyME.db";
    public static final int DATABASE_VERSION = 1;
    public static final String NAME = "name";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String TIME = "time";
    public static final String DATE = "date_aq";
    public static final String TYPE = "type";
    public static final String PRIORITY = "priority";

    private static final String CREATE_TABLE_TASKS = "CREATE TABLE " + TASKS_TABLE + " ( " + NAME + " VARCHAR(30) NOT NULL, " + DESCRIPTION + " VARCHAR(160), " + TITLE + " VARCHAR(60), " +
            TIME + " TIME, " + DATE + " DATE, " + TYPE + " int(1), "+PRIORITY+" int(1) );";
    private static final String DROP_TABLE_TASKS = "DROP TABLE IF EXISTS" + TASKS_TABLE;
    private Context context;
//    private static final String CREATE_TABLE_LEAD = "create table " + LEAD_TABLE + " ( " + LEAD_ID + " varchar(15) NOT NULL, " + FIRSTNAME + " varchar(50) NOT NULL," + REGION +
//            " varchar(15), " + SECONDNAME + " varchar(50)," + NIC_NO + " varchar(10) UNIQUE, " + TELEPHONE_NUMBER_PRIMARY + " int(10), " + TELEPHONE_NUMBER_SECONDARY + " int(14)," +
//            TELEPHONE_NUMBER_TERTIARY + " int(14), " + EMAIL + " varchar(30)," + STATUS +
//            " int(2),"+BRAND+" varchar(15), "  + MODEL + " varchar(30), " + CAPITAL + " double, " + EXPECTED + " double, "+ ADDRESS + " varchar(255) );";
//
//
//    private static final String CREATE_TABLE_VEHICLE = "create table " + VEHICLE_TABLE + " ( " + VEHICLE_ID + " varchar(15) NOT NULL  , " + OFFICER_ID + " varchar(15), " + LEAD_ID_VEHICLE + " varchar(15) NOT NULL,  " +
//            FTYPE_ID + " varchar(10), " + MODEL + " varchar(30), " + CAPITAL + " double, " + EXPECTED + " double, " + REG_YEAR + " int NOT NULL, " + REG_NO + " varchar(15), " + BRAND + " varchar(15) );";
//
//    private static final String CREATE_TABLE_NOTE = "create table " + NOTE_TABLE + " ( " + TITLE + " varchar(100), "+NOTE_ID+" int, " + LEADNAME + " varchar(45), " +
//            NOTE + " varchar(255), " + REMARKS + " varchar(255));";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TASKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_TASKS);
        onCreate(db);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {

        return super.getWritableDatabase();

    }
}
