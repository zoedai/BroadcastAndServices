package com.example.dai.broadcastandservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();

        String action = intent.getAction();

        if (action.equals("android.provider.Telephony.SMS_RECEIVED")) {
            context.startService(new Intent(context, MyService.class));
        } else {
            String phoneNo = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Toast.makeText(context, "Calling "+phoneNo, Toast.LENGTH_LONG).show();
        }
    }
}
