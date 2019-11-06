package com.example.apoorv.activityjnu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by Apoorv on 24-03-2018.
 */

public class IncomingCall extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle b=intent.getExtras();
        if(b!=null)
        {
            String s=b.getString(TelephonyManager.EXTRA_STATE);
            if(s.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                Toast.makeText(context,
                        "YOU HAVE INCOMING CALL FROM "
                        +b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
