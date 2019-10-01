package com.example.servicestationcustomer;

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

public class AddServiceLayout extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editServiceName , edittype , editemp , editNeedPrice , editTextId ;
    Button btnAddData;
    Button btnViewAll;
    Button btnViewUpdate;
    Button btnDelete;
    Button btnDeleteall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_add_service_layout);

        myDb = new DatabaseHelper(this);

        editServiceName = findViewById(R.id.editname2);
        edittype = findViewById(R.id.edittype);
        editemp = findViewById(R.id.editemp);

        editNeedPrice = findViewById(R.id.editneedprice);
        btnAddData = findViewById(R.id.button2);
        btnViewAll = findViewById(R.id.button6);
        editTextId = findViewById(R.id.editText3);
        btnViewUpdate = findViewById(R.id.button12);
        btnDelete = findViewById(R.id.button13);
        AddData();
        viewAll();
        UpdateData();
        Deletedata();

    }
    public void Deletedata(){
        btnDelete.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
                        if(deleteRows>0)
                            Toast.makeText(AddServiceLayout.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddServiceLayout.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData(){
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(), editServiceName.getText().toString(),editemp.getText().toString(),edittype.getText().toString(),editNeedPrice.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(AddServiceLayout.this,"Data Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddServiceLayout.this,"Data not Updated",Toast.LENGTH_LONG).show();

                        }


                }
        );
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
                            Toast.makeText(AddServiceLayout.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddServiceLayout.this,"Data not Inserted",Toast.LENGTH_LONG).show();
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
                            buffer.append("Id :" + res.getString(0)+"\n");
                            buffer.append("servicename :" + res.getString(1)+"\n");
                            buffer.append("servicetype :" + res.getString(2)+"\n");
                            buffer.append("amountofemp :" + res.getString(3)+"\n");
                            buffer.append("needprice :" + res.getString(4)+"\n");
                        }
                        //getalldata
                        showMessage("Services" , buffer.toString());
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

