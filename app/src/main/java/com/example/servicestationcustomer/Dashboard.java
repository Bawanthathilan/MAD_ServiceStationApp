package com.example.servicestationcustomer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_dashboard);
    }
    public void onButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), AddServiceLayout.class);
        startActivity(myIntent);
    }

    public void onselectServiceButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), addCutomerServices.class);
        startActivity(myIntent);
    }
}
