package com.myapp.mylistviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] countryNames;
    int[] flags = {R.drawable.bangladesh_icon,R.drawable.china_icon,R.drawable.india_icon,R.drawable.pakistan_icon,
            R.drawable.japn_icon,R.drawable.canada_icon,R.drawable.maldives_icon,R.drawable.koria_icon,
            R.drawable.german_icon,R.drawable.australia_icon,R.drawable.nepal_icon,R.drawable.tanzania_icon,
            R.drawable.argentina_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryNames = getResources().getStringArray(R.array.country_name);

        listView = (ListView) findViewById(R.id.listViewId);
        CustomAdapter customAdapter = new CustomAdapter(this,countryNames,flags);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String value = countryNames[i];
                Toast.makeText(MainActivity.this,value+" "+i,Toast.LENGTH_SHORT).show();
            }
        });


    }
}