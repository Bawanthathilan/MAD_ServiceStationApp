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

public class updateDelete extends AppCompatActivity {
    DBHelper myDb;
    EditText editcustomerName , editvehicleNumber , editmobile , editService , editTextId ;
    Button btnViewAll;
    Button btnViewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_update_delete);

        myDb = new DBHelper(this);

        editcustomerName = findViewById(R.id.editText4);
        editvehicleNumber = findViewById(R.id.editText5);
        editmobile = findViewById(R.id.editText6);
        editService = findViewById(R.id.editText);
        btnViewAll = findViewById(R.id.btnView);

        editTextId = findViewById(R.id.editText11);
        btnViewUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

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
                            Toast.makeText(updateDelete.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(updateDelete.this,"Please insert a valid ID",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData(){
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        String sID = editTextId.getText().toString();
                        if (sID.matches("")) {
                            Toast.makeText(updateDelete.this, "Please insert a valid ID", Toast.LENGTH_SHORT).show();
                            return;}
                        String sUsername = editcustomerName.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(updateDelete.this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                            return;}
                        String sVehicleNumber = editvehicleNumber.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(updateDelete.this, "You did not enter vehcile Number", Toast.LENGTH_SHORT).show();
                            return;}
                        String sMobileNumber = editmobile.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(updateDelete.this, "You did not enter a mobile", Toast.LENGTH_SHORT).show();
                            return;}
                        String sService = editService.getText().toString();
                        if (sUsername.matches("")) {
                            Toast.makeText(updateDelete.this, "You did not enter service", Toast.LENGTH_SHORT).show();
                            return;}
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(), editcustomerName.getText().toString(),
                                editvehicleNumber.getText().toString(),
                                editmobile.getText().toString  (),
                                editService.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(updateDelete.this,"Data Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(updateDelete.this,"Data not Updated",Toast.LENGTH_LONG).show();

                    }


                }
        );
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("Customer Name :" + res.getString(1) + "\n");
                            buffer.append("Vehicle Number :" + res.getString(2) + "\n");
                            buffer.append("amountofemp :" + res.getString(3) + "\n");
                            buffer.append("needprice :" + res.getString(4) + "\n");
                        }
                        //getalldata
                        showMessage("Customer Services", buffer.toString());
                    }

                }
        );

    }

    public void showMessage(String title , String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

