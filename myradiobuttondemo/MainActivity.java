package com.myapp.myradiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton gender;
    private Button showButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        showButton = (Button) findViewById(R.id.showButtonId);
        resultText = (TextView) findViewById(R.id.resultTextId);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                gender = (RadioButton) findViewById(selectedId);
                String value = gender.getText().toString();
                resultText.setText(value+" is selected.");

            }
        });
    }
}