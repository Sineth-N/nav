package com.d2s2.sinethn.nav.Alarm;

import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

public class Remind extends Service {
    public Remind() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");


    }


    @Override
    public void onCreate() {



        Intent in=new Intent(getApplicationContext(),ListeningActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //in.putExtra("service",r);
        startActivity(in);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
