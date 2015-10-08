package com.d2s2.sinethn.nav.Alarm;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Heshan Sandamal on 10/8/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context k1, Intent k2) {
        // TODO Auto-generated method stub

        Intent intent=new Intent(k1,Remind.class);
        k1.startService(intent);





    }

}
