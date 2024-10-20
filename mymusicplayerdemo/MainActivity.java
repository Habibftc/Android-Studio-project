package com.myapp.mymusicplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton playButton, pauseButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (ImageButton) findViewById(R.id.playId);
        pauseButton = (ImageButton) findViewById(R.id.pauseId);

       mediaPlayer = MediaPlayer.create(this,R.raw.travel_video);
       playButton.setOnClickListener((View.OnClickListener) MainActivity.this);
       pauseButton.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.playId){
            if (mediaPlayer!=null){
                mediaPlayer.start();
                int duration=mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this,"Play"+duration,Toast.LENGTH_SHORT).show();
            }

        }
        if (view.getId()==R.id.pauseId){
            if (mediaPlayer!=null){
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this,"Pause",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}