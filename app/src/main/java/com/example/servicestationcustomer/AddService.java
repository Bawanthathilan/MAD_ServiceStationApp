package com.example.servicestationcustomer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
    }
    public void onButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), InsertSuccessFully.class);
        startActivity(myIntent);
    }

}
