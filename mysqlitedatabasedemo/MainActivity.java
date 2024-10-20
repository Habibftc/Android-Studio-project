package com.myapp.mysqlitedatabasedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText,ageEditText,genderEditText,idEditText;
    private Button addButton , displayButton,updateButton,deleteButton;
    MydatabaseHelper mydatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabaseHelper = new MydatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = mydatabaseHelper.getReadableDatabase();
        idEditText = (EditText)findViewById(R.id.IdEditTextId); 
        nameEditText =(EditText)findViewById(R.id.nameEditTextId);
        ageEditText = (EditText) findViewById(R.id.ageEditTextId);
        genderEditText = (EditText) findViewById(R.id.genderEditTextId);
        addButton = (Button) findViewById(R.id.addButtonId);
        updateButton = (Button)findViewById(R.id.updateButtonId); 
        displayButton = (Button)findViewById(R.id.displayButtonId);
        deleteButton = (Button)findViewById(R.id.deleteButtonId);
        addButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        if (view.getId()==R.id.addButtonId){
            long rowId = mydatabaseHelper.insertData(name,age,gender);
            if (rowId==-1){
                Toast.makeText(getApplicationContext(),"unsuccessful",Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(),"Row "+rowId+" is successfully inserted",Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId()==R.id.displayButtonId){

            Cursor cursor =mydatabaseHelper.DisplayAllData();
            if (cursor.getCount()==0){
                showData("Error","No Data Found");

                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()){
                stringBuffer.append("ID :" + cursor.getString(0)+"\n");
                stringBuffer.append("Name :" + cursor.getString(1)+"\n");
                stringBuffer.append("Age :" + cursor.getString(2)+"\n");
                stringBuffer.append("Gender :" + cursor.getString(3)+"\n\n\n");

            }
            showData("ResultSet",stringBuffer.toString());

        }
        else if (view.getId()==R.id.updateButtonId) {

            Boolean isUpdated =  mydatabaseHelper.updateData(id,name,age,gender);
            if (isUpdated==true){
                Toast.makeText(getApplicationContext(),"Data is updated",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"Data is not updated",Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId()==R.id.deleteButtonId){

            int value = mydatabaseHelper.deleteData(id);
            if (value>0){
                Toast.makeText(getApplicationContext(),"Data is Deleted Successfully",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"Data is Not Deleted",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void showData(String title,String massage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(massage);
        builder.setCancelable(true);
        builder.show();
    }
}