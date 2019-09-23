package com.example.servicestationcustomer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addCutomerServices extends AppCompatActivity {

    DBHelper myDb;
    EditText editcustomerName , editvehicleNumber , editmobile , editService , editTextId ;
    Button btnAddData;
    Button btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_add_cutomer_services);

        myDb = new DBHelper(this);

        editcustomerName = findViewById(R.id.editText4);
        editvehicleNumber = findViewById(R.id.editText5);
        editmobile = findViewById(R.id.editText6);

        editService = findViewById(R.id.editText7);
        btnAddData = findViewById(R.id.buttonadd);
        btnViewAll = findViewById(R.id.btnView);
        //editTextId = findViewById(R.id.editText3);
        //btnViewUpdate = findViewById(R.id.btnUpdate);
        //btnDelete = findViewById(R.id.button13);
        AddData();
        viewAll();
        //UpdateData();
        //Deletedata();

    }
    public void onDeleteButtonClick(View view){
        Intent myIntent = new Intent(getBaseContext(), updateDelete.class);
        startActivity(myIntent);
    }

    public void onButtonUpdateClick(View view){
        Intent myIntent = new Intent(getBaseContext(), updateDelete.class);
        startActivity(myIntent);
    }

    public void AddData(){
        btnAddData.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        String sUsername = editcustomerName.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(MainActivity.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                            return;}
                        String sVehicleNumber = editvehicleNumber.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(MainActivity.this, "Please enter vehicle Number", Toast.LENGTH_SHORT).show();
                            return;}
                        String sMobileNumber = editmobile.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(MainActivity.this, "Please enter a mobile", Toast.LENGTH_SHORT).show();
                            return;}
                        String sService = editService.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(MainActivity.this, "Please enter a service", Toast.LENGTH_SHORT).show();
                            return;}

                        boolean isInserted = myDb.insertData(editcustomerName.getText().toString(),
                                editvehicleNumber.getText().toString(),
                                editmobile.getText().toString  (),
                                editService.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(addCutomerServices.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(addCutomerServices.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Cursor res = myDb.getAllData();
                        if (res.getCount()==0){
                            //show message
                            showMessage("Error" ,"Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("ID :" + res.getString(0)+"\n");
                            buffer.append("Customer Name :" + res.getString(1)+"\n");
                            buffer.append("Vehicle Number :" + res.getString(2)+"\n");
                            buffer.append("Mobile Number :" + res.getString(3)+"\n");
                            buffer.append("Service :" + res.getString(4)+"\n");
                        }
                        //getalldata
                        showMessage("Customer Services" , buffer.toString());
                    }

                }
        );
    }
    public void showMessage(String title , String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

