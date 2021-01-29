package com.dkuzmy3.project_3_receiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String HYPER_PERMISSION = "edu.uic.cs478.sp2020.chitowndanger";

    myBroadcastReceiver br = new myBroadcastReceiver();     // get instance of broadcastReceiver

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("com.dkuzmy3.MY_BROADCAST");
        registerReceiver(br, filter, HYPER_PERMISSION, null);
        //registerReceiver(br, filter);

        Intent intent0 = new Intent(getApplicationContext(), restaurantsActivity.class);
        Intent intent1 = new Intent(getApplicationContext(), interestActivity.class);

        if(br.received.equals("interest")){finishActivity(1); startActivity(intent1);}
        if(br.received.equals("restaurants")){finishActivity(1); startActivity(intent0);}

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);         // unregister the receiver when app dies
    }
}