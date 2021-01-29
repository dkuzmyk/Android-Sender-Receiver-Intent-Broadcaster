package com.dkuzmy3.project_3_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class myBroadcastReceiver extends BroadcastReceiver {

    String received = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("intent Action:", intent.getAction());
        if("com.dkuzmy3.MY_BROADCAST".equals(intent.getAction())){
            received = intent.getStringExtra("com.dkuzmy3.MY_BROADCAST");
            Log.i("checking: ", received);
            if(received == "interest"){
                Toast.makeText(context, received, Toast.LENGTH_LONG).show();
            }

            if(received == "restaurants"){
                Toast.makeText(context, received, Toast.LENGTH_LONG).show();
            }
        }

    }
}
