package com.dkuzmy3.project_3_receiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class interestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction frt = fragmentManager.beginTransaction();
        frt.replace(R.id.frame_container, new interest_fragment());
        frt.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu_res, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.interest_menu:
                return true;
            case R.id.rest_menu:
                Intent intent0 = new Intent(getApplicationContext(), restaurantsActivity.class);
                startActivity(intent0);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

/*
    @Override
    public void onInputASent(int input) {
        FragmentA
    }*/
}