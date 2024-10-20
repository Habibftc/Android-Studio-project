package com.myapp.mysharedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton shareButton,feedbackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareButton = (ImageButton) findViewById(R.id.shareId);
        shareButton.setOnClickListener( this);

        feedbackButton = (ImageButton) findViewById(R.id.feedbackId);
        feedbackButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (shareButton.getId()==R.id.shareId){
            Toast.makeText(MainActivity.this,"Share",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sub = "My application";
            String body = " com.myapp.mysharedemo";
            intent.putExtra(Intent.EXTRA_SUBJECT,sub);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share with "));
        }
         if(feedbackButton.getId()==R.id.feedbackId){
                Intent intent = new Intent(getApplicationContext(),feedback.class);
                startActivity(intent);
        }

    }
}