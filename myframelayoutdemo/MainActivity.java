package com.myapp.myframelayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView habib,nizam,arman,ishfar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        habib = (ImageView) findViewById(R.id.habibId);
        nizam = (ImageView) findViewById(R.id.nizamId);
        arman = (ImageView) findViewById(R.id.armanId);
        ishfar= (ImageView) findViewById(R.id.ishfarId);

        habib.setOnClickListener(this);
        nizam.setOnClickListener(this);
        arman.setOnClickListener(this);
        ishfar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.habibId){
            habib.setVisibility(View.GONE);
            nizam.setVisibility(View.VISIBLE);
        } else if (view.getId()==R.id.nizamId) {
            nizam.setVisibility(View.GONE);
            arman.setVisibility(View.VISIBLE);

        }else if (view.getId()==R.id.armanId) {
            arman.setVisibility(View.GONE);
            ishfar.setVisibility(View.VISIBLE);

        }else if (view.getId()==R.id.ishfarId) {
            ishfar.setVisibility(View.GONE);
            habib.setVisibility(View.VISIBLE);

        }
    }
}