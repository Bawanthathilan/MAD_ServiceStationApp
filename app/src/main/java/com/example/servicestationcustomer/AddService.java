package com.example.servicestationcustomer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class AddService extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editServiceName , edittype , editemp , editNeedPrice ;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        myDb = new DatabaseHelper(this);

        editServiceName = (EditText)findViewById(R.id.editname);
        edittype = (EditText)findViewById(R.id.edittype);
        editemp = (EditText)findViewById(R.id.editemp);

        editNeedPrice = (EditText)findViewById(R.id.editneedprice);
        AddData();

    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editServiceName.getText().toString(),
                                edittype.getText().toString(),
                                editemp.getText().toString(),
                                editNeedPrice.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(AddService.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddService.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
   // public void onButtonClick(View v){
        //Intent myIntent = new Intent(getBaseContext(), InsertSuccessFully.class);
       // startActivity(myIntent);
    //}

}
