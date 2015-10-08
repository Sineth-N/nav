package com.d2s2.sinethn.nav;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.d2s2.sinethn.nav.Database.DBHelper;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Sineth on 10/8/2015.
 */
public class SMSWriterSQLite {

    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private ContentValues values;
    private android.support.v7.app.AlertDialog.Builder alert;
    static String notifyMe;
    static String title;
    static String description;
    static String time;
    static String date;
    static String priority;

    public SMSWriterSQLite(Context context) {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        values = new ContentValues();
    }

    public void writeToDatabase(String name, String title, String description, String time, String date, String type, String priority) {
        values.put(DBHelper.NAME, name);
        values.put(DBHelper.TITLE, title);
        values.put(DBHelper.DESCRIPTION, description);
        values.put(DBHelper.TIME, String.valueOf(Time.valueOf(time)));
        values.put(DBHelper.DATE, String.valueOf(Date.valueOf(date)));
        values.put(DBHelper.TYPE, type);
        values.put(DBHelper.PRIORITY, priority);
        Long i=0L;
        try {
            i = database.insert(DBHelper.TASKS_TABLE, null, values);
            database.close();
        }catch (Exception e){
            Log.d("Error","SQLite error occured");
        }finally {
            if (i==-1){
                alert.setMessage("Error in data you entered \n please make sure that you are not duplicating records.");
                alert.setCancelable(true);
                alert.show();
            }else {
                Log.i("Success","SQLite data entered");
//                alert.setMessage("Successfully Added to the database");
//                alert.setCancelable(true);
//                alert.show();

            }
        }
    }
}
