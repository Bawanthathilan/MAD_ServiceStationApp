package com.example.servicestationcustomer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InsertSuccessFully extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_success_fully);
    }
    public void onButtonClick(View v){
        Intent myIntent = new Intent(this, updateservice.class);
        startActivity(myIntent);
    }
}
