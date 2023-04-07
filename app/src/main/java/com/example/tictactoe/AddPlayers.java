package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText playerOne= findViewById(R.id.playerOneName);
        final EditText playerTwo= findViewById(R.id.playerTwoName);
        final Button startgameBtn= findViewById(R.id.StartGameBtn);

        startgameBtn.setOnClickListener(
                new
        );
    }
}