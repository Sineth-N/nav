package com.d2s2.sinethn.nav.Alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.d2s2.sinethn.nav.R;

import java.util.Calendar;

public class MainActivityAlarm extends Activity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    TextView textAlarmPrompt;
    TimePickerDialog timePickerDialog;
    Calendar calNow = Calendar.getInstance();
    Calendar calSet = (Calendar) calNow.clone();
    Calendar calendar = Calendar.getInstance();
    final static int RQS_1 = 1;
    //private AlertDialog


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_layout);

        textAlarmPrompt = (TextView) findViewById(R.id.alarmprompt);

        buttonstartSetDialog = (Button) findViewById(R.id.startAlaram);
        buttonstartSetDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textAlarmPrompt.setText("");
                openTimePickerDialog(false);
                openDatePickerDialog();


            }
        });


        //check database value
        //if have value add the description to textbox

        Button delButton=(Button)findViewById(R.id.almdelete);
        delButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        getBaseContext(), RQS_1, intent, 0);
                alarmManager.cancel(pendingIntent);


            }
        });


    }

    private void openDatePickerDialog(){

        DatePickerDialog dp = new DatePickerDialog(MainActivityAlarm.this, onDateSetListener , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dp.show();
    }

    private void openTimePickerDialog(boolean is24r) {



        timePickerDialog = new TimePickerDialog(MainActivityAlarm.this, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), is24r);
        timePickerDialog.setTitle("Set Alarm Time");

        timePickerDialog.show();

    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            calSet.set(Calendar.YEAR, i);
            calSet.set(Calendar.MONTH, i2);
            calSet.set(Calendar.DAY_OF_MONTH, i3);

        }
    };

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {




            //DatePicker dp=new Dat
            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

//            if (calSet.compareTo(calNow) <= 0) {
//                // Today Set time passed, count to tomorrow
//                calSet.add(Calendar.DATE, 1);
//            }

            setAlarm(calSet);
        }
    };

    private void setAlarm(Calendar targetCal) {

        textAlarmPrompt.setText("\n\n***\n" + "Alarm is set "
                + targetCal.getTime() + "\n" + "***\n");

        //add to database

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
                pendingIntent);

       // alarmManager.cancel();

    }
}