package com.myapp.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyDatabaseHelper myDatabaseHelper;
    private EditText usernameEditText,passwordEditText;
    private Button signInButton,signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =  myDatabaseHelper.getWritableDatabase();
        usernameEditText = (EditText) findViewById(R.id.usernameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);

        signInButton = (Button) findViewById(R.id.signinButtonId);
        signUpButton = (Button) findViewById(R.id.signupButtonId);

        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (view.getId()==R.id.signinButtonId){
            Boolean result = myDatabaseHelper.Findpassword(username,password);
            if (username.isEmpty()){
                usernameEditText.setError("Please enter your USER ID");
                usernameEditText.requestFocus();
                return;
            }
            if (result==true){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"Username or password not match",Toast.LENGTH_SHORT).show();
            }

        }
        else if (view.getId()==R.id.signupButtonId){
            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
           startActivity(intent);

        }

    }
}