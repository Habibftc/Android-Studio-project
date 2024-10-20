package com.myapp.mysharedpreparenceuserdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userId,passwordId;
    private Button save,load;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId = (EditText) findViewById(R.id.usernameId);
        passwordId = (EditText) findViewById(R.id.passwordId);
        save = (Button) findViewById(R.id.saveId);
        load = (Button) findViewById(R.id.loadId);
        textView = (TextView) findViewById(R.id.textViewId);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.saveId){
            String uername = userId.getText().toString();
            String password = passwordId.getText().toString();
            if (uername.equals("")&&password.equals("")){
                Toast.makeText(getApplicationContext(),"Please enter data",Toast.LENGTH_SHORT).show();
            }else {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey",uername);
                editor.putString("passwordKey",password);
                editor.commit();
                userId.setText("");
                passwordId.setText("");
                Toast.makeText(getApplicationContext(),"Data is store successfully",Toast.LENGTH_SHORT).show();
            }

        }
        else if (view.getId()==R.id.loadId){
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails",Context.MODE_PRIVATE);
                if (sharedPreferences.contains("usernameKey")&&sharedPreferences.contains("passwordKey")){
                    String username = sharedPreferences.getString("usernameKey","Data not fund");
                    String password = sharedPreferences.getString("passwordKey","Data not fund");
                    textView.setText(username+'\n'+password);

                }
        }

    }
}