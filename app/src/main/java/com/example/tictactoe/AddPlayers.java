package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText playerOne= findViewById(R.id.playerOneName);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        final EditText playerTwo= findViewById(R.id.playerTwoName);

        playerOne.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(v, 0);
                } else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        playerTwo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(v, 0);
                } else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });
        final Button StartGameBtn= findViewById(R.id.StartGameBtn);

        StartGameBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
            public void onClick(View v){
                        final String getPlayerOneName= playerOne.getText().toString();
                        final String getPlayerTwoName= playerTwo.getText().toString();

                        if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                            Toast.makeText(AddPlayers.this, "Please Enter Players Name", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent= new Intent(AddPlayers.this, gameMechanics.class);
                            intent.putExtra("playerOne", getPlayerOneName);
                            intent.putExtra("playerTwo", getPlayerTwoName);
                            startActivity(intent);

                        }
                    }
                }
        );
    }


}