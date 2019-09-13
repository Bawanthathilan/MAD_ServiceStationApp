package com.example.servicestationcustomer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void onButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), AddService.class);
        startActivity(myIntent);
    }
}
