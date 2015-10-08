package com.d2s2.sinethn.nav.BroadcastListeners;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import com.d2s2.sinethn.nav.Message;
import com.d2s2.sinethn.nav.SMSWriterSQLite;

import java.util.StringTokenizer;

/**
 * Created by Sineth on 10/8/2015.
 */
public class SMSBroadcastListener extends BroadcastReceiver {

    final SmsManager sms = SmsManager.getDefault();
    SMSWriterSQLite smsWriterSQLite;
    static String notifyMe;
    static String title;
    static String description;
    static String time;
    static String date;
    static String priority;

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        smsWriterSQLite = new SMSWriterSQLite(context);
        //try {

        if (bundle != null) {

            final Object[] pdusObj = (Object[]) bundle.get("pdus");

            for (int i = 0; i < pdusObj.length; i++) {

                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                String senderNum = phoneNumber;
                String message = currentMessage.getDisplayMessageBody();

                Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                validate(message, context);
                String contactName = getContactName(context, senderNum);
                Message.message(context, contactName);

                // Show alert
//                    int duration = Toast.LENGTH_LONG;
//                    Toast toast = Toast.makeText(context, "senderNum: "+ senderNum + ", message: " + message, duration);
//                    toast.show();
                smsWriterSQLite.writeToDatabase(getContactName(context, senderNum), title, description, time, date, "1", priority);

            } // end for loop
        } // bundle is null

        //}catch (Exception e) {
        //    Log.e("SmsReceiver", "Exception smsReceiver" +e);
        //}
    }

    public boolean validate(String message, Context context) {

        String[] msg = new String[6];
        int i = 0;
        StringTokenizer st = new StringTokenizer(message, "$#");
        while (st.hasMoreElements()) {
            msg[i] = (String) st.nextElement();
            i++;
        }
        notifyMe = msg[0];
        title = msg[1];
        description = msg[2];
        time = msg[3];
        date = msg[4];
        priority = msg[5];

        title = title.substring(2);   //ti
        description = description.substring(1);//d
        time = time.substring(1);//t
        date = date.substring(2);//da
        priority = priority.substring(1);//p
        Log.i("SmsReceiver", "title smsReceiver " + title);
        Log.i("SmsReceiver", "description smsReceiver " + description);
        Log.i("SmsReceiver", "time smsReceiver " + time);
        Log.i("SmsReceiver", "date smsReceive " + date);
        Log.i("SmsReceiver", "priority smsReceiver " + priority);
        return true;
    }

    public static String getContactName(Context context, String phoneNumber) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactName = null;
        if (cursor.moveToFirst()) {
            contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return contactName;
    }
}
