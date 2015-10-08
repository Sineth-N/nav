package com.d2s2.sinethn.nav;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.d2s2.sinethn.nav.Database.DBHelper;

import java.sql.DatabaseMetaData;


public class SecondActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private DBHelper dbHelper;
    private EditText title,leadName,note,remarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar = (Toolbar) findViewById(R.id.app_bar_3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title=(EditText) findViewById(R.id.titleET);
        leadName=(EditText) findViewById(R.id.leadNameET);
        note=(EditText) findViewById(R.id.noteET);
        remarks=(EditText) findViewById(R.id.remarksEt);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.home) {

        }
        return super.onOptionsItemSelected(item);
    }
    public void clicked(View view){
//        dbHelper=new DBHelper(this);
//        SQLiteDatabase database=dbHelper.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put(DBHelper.TITLE,title.getText().toString());
//        values.put(DBHelper.LEADNAME,leadName.getText().toString());
//        values.put(DBHelper.REMARKS, remarks.getText().toString());
//        values.put(DBHelper.NOTE,note.getText().toString());
//        values.put(DBHelper.NOTE_ID,0);
//        long i=database.insert(DBHelper.NOTE_TABLE,null,values);
//        if(i==-1){
//            Message.message(getBaseContext(),"Failed");
//        }else
//            Message.message(getBaseContext(),"com.d2s2.sinethn.nav.TaskNotify added");
//
    }
}
