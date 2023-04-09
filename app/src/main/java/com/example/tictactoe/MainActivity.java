package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
         TextView playerOneName= findViewById(R.id.playerOneName);
         TextView playerTwoName= findViewById(R.id.playerTwoName);

         LinearLayout playerOneLayout= findViewById(R.id.playerOneLayout);
         LinearLayout playerTwoLayout=findViewById(R.id.playerTwoLayout);

         ImageView image1=findViewById(R.id.image1);
         ImageView image2=findViewById(R.id.image2);
         ImageView image3=findViewById(R.id.image3);
         ImageView image4=findViewById(R.id.image4);
         ImageView image5=findViewById(R.id.image5);
         ImageView image6=findViewById(R.id.image6);
         ImageView image7=findViewById(R.id.image7);
         ImageView image8=findViewById(R.id.image8);
         ImageView image9=findViewById(R.id.image9);

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
//         playerOneLayout.setOnClickListener(new View.OnClickListener(){
//             public void onClick(View v){
//
//             }
//         });
//        playerTwoLayout.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//
//            }
//        });
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)){

                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)){

                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)){

                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)){

                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)){

                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)){

                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)){

                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)){

                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)){

                }
            }
        });

    }

    private void performAction(ImageView imageView, int selectedBoxPosition){
        //setting the image with the players
        boxPositions[selectedBoxPosition]= playerTurn;
        if (playerTurn==1){
            imageView.setImageResource(R.drawable.cross_icon);
        }
       if(checkPlayerWin()){

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
}