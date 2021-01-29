package com.dkuzmy3.project_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_BROADCAST = "com.dkuzmy3.MY_BROADCAST";
    private static final String MY_INTEREST = "interest";
    private static final String MY_RESTAURANTS = "restaurants";
    private static final String HYPER_PERMISSION = "edu.uic.cs478.sp2020.chitowndanger";
    Button restButton;
    Button hotelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restButton = findViewById(R.id.searchRestaurants);
        hotelButton = findViewById(R.id.searchHotels);

        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeToast();
                checkPermission(MY_RESTAURANTS);
            }
        });

        hotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeToast();
                checkPermission(MY_INTEREST);
            }
        });
    }

    private void checkPermission(String info) {
        if (ContextCompat.checkSelfPermission(this, HYPER_PERMISSION)
                == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MY_BROADCAST);
            intent.putExtra(MY_BROADCAST, info);
            //sendBroadcast(intent, HYPER_PERMISSION);

            sendBroadcast(intent);

        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {HYPER_PERMISSION}, 0);
        }
    }

    public void makeToast() {
        Toast.makeText(
                this, "Searching!", Toast.LENGTH_SHORT).show();
    }






}