package com.myapp.mysharedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity implements View.OnClickListener {
    private Button submitButton,clearButton;
    private EditText nameText,feedbackText;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        submitButton = (Button) findViewById(R.id.submitId);
        clearButton = (Button) findViewById(R.id.clearId);

        nameText = (EditText) findViewById(R.id.nameEditTextId);
        feedbackText= (EditText) findViewById(R.id.feedbackId);
        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       try {
           String name = nameText.getText().toString();
           String massage = feedbackText.getText().toString();
           if (view.getId()==R.id.submitId){

               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/email");

               intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"habibftc54@gmail.com"});
               intent.putExtra(Intent.EXTRA_SUBJECT,"Feed back from app");
               intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name+"\n Massage : "+massage);
               startActivity(Intent.createChooser(intent,"Feedback with"));

           }else if (view.getId()==R.id.clearId){
               nameText.setText("");
               feedbackText.setText("");
           }
       }catch (Exception e ){
           Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();
       }

    }
}