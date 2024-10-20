package com.myapp.myspinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] countryNames;
    private Spinner spinner;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryNames = getResources().getStringArray(R.array.country_name);
        spinner = (Spinner) findViewById(R.id.spinnerId);
        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleViewId,countryNames);
        spinner.setAdapter(adapter);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String value = spinner.getSelectedItem().toString();
               textView.setText(value);
           }
       });
    }
}