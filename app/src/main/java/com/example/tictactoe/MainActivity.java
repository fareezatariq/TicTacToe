package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final List<int[]> combinationList= new ArrayList<>();
    private int[] boxPositions= {0,0,0,0,0,0,0,0,0};
    private int playerTurn=1;
    private int totalSelectBoxes=1;

    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playerTwoName;
    private ImageView image1, image2,image3,image4,image5,image6,image7,image8,image9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);

          playerOneName= findViewById(R.id.playerOneName);
          playerTwoName= findViewById(R.id.playerTwoName);

          image1=findViewById(R.id.image1);
          image2=findViewById(R.id.image2);
          image3=findViewById(R.id.image3);
          image4=findViewById(R.id.image4);
          image5=findViewById(R.id.image5);
          image6=findViewById(R.id.image6);
          image7=findViewById(R.id.image7);
          image8=findViewById(R.id.image8);
          image9=findViewById(R.id.image9);

         //combinations that can be made
         combinationList.add(new int[]{0,1,2});
         combinationList.add(new int[]{3,4,5});
         combinationList.add(new int[]{6,7,8});
         combinationList.add(new int[]{0,3,6});
         combinationList.add(new int[]{1,4,7});
         combinationList.add(new int[]{2,5,8});
         combinationList.add(new int[]{2,4,6});
         combinationList.add(new int[]{0,4,8});

         //getting the name of the players from AddPlayers
        final String getPlayerOneName= getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName= getIntent().getStringExtra("playerTwo");
        //setting the name of players
        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image8.setOnClickListener(this);
        image9.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image1:performAction((ImageView)v,1);
            break;
            case R.id.image2:performAction((ImageView)v,2);
                break;
            case R.id.image3:performAction((ImageView)v,3);
                break;
            case R.id.image4:performAction((ImageView)v,4);
                break;
            case R.id.image5:performAction((ImageView)v,5);
                break;
            case R.id.image6:performAction((ImageView)v,6);
                break;
            case R.id.image7:performAction((ImageView)v,7);
                break;
            case R.id.image8:performAction((ImageView)v,8);
                break;
            case R.id.image9:performAction((ImageView)v,9);
                break;

        }
    }
    private void performAction(ImageView imageView, int selectedBoxPosition){
        //setting the image with the players
        boxPositions[selectedBoxPosition-1]= playerTurn;
        if (playerTurn==1){
            imageView.setImageResource(R.drawable.cross_icon);
            //if P1 wins display message
            if(checkPlayerWin()){
                Dialog winDialog= new WinDialog(MainActivity.this,playerOneName.getText().toString()+ " has won the match!", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if (totalSelectBoxes==9){
                Dialog winDialog= new WinDialog(MainActivity.this,"It is a draw", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.zero_icon);
            //if P2 wins display message
            if(checkPlayerWin()){
                Dialog winDialog= new WinDialog(MainActivity.this,playerTwoName.getText().toString()+ " has won the match!", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if (totalSelectBoxes==9){
                Dialog winDialog= new WinDialog(MainActivity.this,"It is a draw", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn= currentPlayerTurn;
        if(playerTurn ==1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_border_dark_blue);
        }
        else{
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_border_dark_blue);
        }

    }

    //function to check in winning combination is made
    private boolean checkPlayerWin(){
        boolean response= false;
        for (int i=0;i<combinationList.size();i++){
            final int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]]== playerTurn &&boxPositions[combination[1]]==playerTurn &&boxPositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return response;
    }

    //function to check is the box is already taken
    private boolean isBoxSelectable(int boxPosition){
     boolean response=false;
     if(boxPositions[boxPosition]==0){
         response=true;
     }
     return response;
    }
    public void reStartMatch(){
        boxPositions= new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalSelectBoxes=1;
        image1.setImageResource(R.drawable.transparent_bg);
        image2.setImageResource(R.drawable.transparent_bg);
        image3.setImageResource(R.drawable.transparent_bg);
        image4.setImageResource(R.drawable.transparent_bg);
        image5.setImageResource(R.drawable.transparent_bg);
        image6.setImageResource(R.drawable.transparent_bg);
        image7.setImageResource(R.drawable.transparent_bg);
        image8.setImageResource(R.drawable.transparent_bg);
        image9.setImageResource(R.drawable.transparent_bg);
    }
}