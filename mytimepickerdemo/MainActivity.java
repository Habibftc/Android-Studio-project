package com.myapp.mytimepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewId);
        button = (Button) findViewById(R.id.buttonId);
        timePicker = (TimePicker) findViewById(R.id.timePickerId);
        timePicker.setIs24HourView(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = timePicker.getCurrentHour()+" : "+timePicker.getCurrentMinute();
                textView.setText(time);
            }
        });
    }
}