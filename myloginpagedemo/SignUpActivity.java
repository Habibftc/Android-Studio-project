package com.myapp.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText nameEditText,emailEditText,usernameEditText,passwordEditText;
    private Button signupButton;
    userDetails details;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameEditText = (EditText) findViewById(R.id.name2EditTextId);
        emailEditText = (EditText) findViewById(R.id.email2EditTextId);
        usernameEditText = (EditText) findViewById(R.id.username2EditTextId);
        passwordEditText = (EditText) findViewById(R.id.password2EditTextId);

        signupButton = (Button) findViewById(R.id.signup2ButtonId);
        myDatabaseHelper = new MyDatabaseHelper(this);
        details = new userDetails();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                details.setName(name);
                details.setEmail(email);
                details.setUsername(username);
                details.setPassword(password);
                long rowId = myDatabaseHelper.insertData(details);
                if (name.isEmpty()){
                    nameEditText.setError("Please enter your full name");
                    nameEditText.requestFocus();
                    return;
                }
                if (email.isEmpty()){
                    emailEditText.setError("Please enter a valid email address");
                    emailEditText.requestFocus();
                    return;
                }
                if (username.isEmpty()){
                    usernameEditText.setError("Please enter an User Name");
                    usernameEditText.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    passwordEditText.setError("Please set a password");
                    passwordEditText.requestFocus();
                    return;
                }
                if (rowId>0){
                    Toast.makeText(getApplicationContext(),"Account create successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Account creating fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}