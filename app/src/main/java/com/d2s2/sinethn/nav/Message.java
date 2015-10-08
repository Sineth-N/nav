package com.d2s2.sinethn.nav;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sineth N on 8/10/2015.
 */
public class Message {
    public static void message(Context context,String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
