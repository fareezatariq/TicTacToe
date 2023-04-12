package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
//    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        h.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i= new Intent(MainActivity.this, SplashScreen.class);
//                startActivity(i);
//                finish();
//            }
//        }, 3000);
        Intent intent = new Intent(this, gameMechanics.class);
        startActivity(intent);
    }
}