package com.myapp.myfirebaselogindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signUpemailEditText,signUppasswordEditText;
    private TextView signUpTextView;
    private Button signUpButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign up Activity");
        mAuth = FirebaseAuth.getInstance();
        signUpemailEditText=(EditText) findViewById(R.id.signInEmailTextId2);
        signUppasswordEditText=(EditText) findViewById(R.id.passwordTextId2);
        signUpButton=(Button) findViewById(R.id.signInButtonId2);
        signUpTextView = (TextView) findViewById(R.id.signupTextViewId2);
        signUpButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBerId2);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.signInButtonId2){
            userRegister();

        }else if (view.getId()==R.id.signupTextViewId2){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

    }

    private void userRegister() {
        String email = signUpemailEditText.getText().toString().trim();
        String password = signUppasswordEditText.getText().toString().trim();
        if (email.isEmpty()){
            signUpemailEditText.setError("Please enter an email address");
            signUpemailEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signUpemailEditText.setError("Please enter a valid email address");
            signUpemailEditText.requestFocus();
            return;
        }
        if (password.isEmpty()){
            signUppasswordEditText.setError("Please enter a password");
            signUppasswordEditText.requestFocus();
            return;
        }
        if (password.length()<6){
            signUppasswordEditText.setError("Minimum length of password should be 6");
            signUppasswordEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Register is successful",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Register is not successful",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}