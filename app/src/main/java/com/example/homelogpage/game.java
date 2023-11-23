package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class game extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>();
    private int [] boxpositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    private LinearLayout player1layout,player2layout;
    private TextView player1name,player2name;
    private ImageView box1,box2,box3,box4,box5,box6,box7,box8,box9;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final TextView player1name = findViewById(R.id.player1name);
        final TextView player2name = findViewById(R.id.player2name);

        final LinearLayout player1layout = findViewById(R.id.player1layout);
        final LinearLayout player2layout = findViewById(R.id.player2layout);

        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        box4 = findViewById(R.id.box4);
        box5 = findViewById(R.id.box5);
        box6 = findViewById(R.id.box6);
        box7 = findViewById(R.id.box7);
        box8 = findViewById(R.id.box8);
        box9 = findViewById(R.id.box9);

        combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{2,4,6});
        combinationsList.add(new int[]{0,4,8});


        final String getplayer1name = getIntent().getStringExtra("player1");
        final String getplayer2name = getIntent().getStringExtra("player2");

        player1name.setText(getplayer1name);
        player2name.setText(getplayer2name);


        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){
                    try{ performAction((ImageView)view,0);}
                    catch (NullPointerException ex){ex.printStackTrace();}
                }
            }
        });

        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    try{performAction((ImageView)view,1);}
                    catch (NullPointerException ex){ex.printStackTrace();}

                }
            }
        });

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    try{performAction((ImageView)view,2);}
                    catch (NullPointerException ex){ex.printStackTrace();}

                }
            }
        });

        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isBoxSelectable(3)){
                    try{
                        performAction((ImageView)view,3);}
                    catch (NullPointerException ex){ex.printStackTrace();}

                }

            }
        });

        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    try{performAction((ImageView)view,4);}
                    catch (NullPointerException ex){ex.printStackTrace();}

                }

            }
        });

        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isBoxSelectable(5)){
                    try{performAction((ImageView)view,5);}
                    catch (NullPointerException ex){ex.printStackTrace();}

                }

            }
        });

        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView)view,6);

                }
            }
        });

        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    try{
                        performAction((ImageView)view,7);}catch (NullPointerException ex){ex.printStackTrace();}
                }

            }
        });

        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    try{performAction((ImageView)view,8);}
                    catch (NullPointerException ex){ex.printStackTrace();}
                }

            }
        });



    }

    private void performAction(ImageView imageView ,int selectedBoxPosition){
        boxpositions[selectedBoxPosition]=playerTurn;
        if(playerTurn==1){
            imageView.setImageResource(R.drawable.x);

            if(checkplayerWin()){

                win win = new win(game.this,"X has WON The Match", game.this);
                win.setCancelable(false);
                win.show();
            }
            else if(totalSelectedBoxes==9){
                win win = new win(game.this,"It is A DRAW!", game.this);
                win.setCancelable(false);
                win.show();

            }

            else{
                try{
                    changeplayerTurn(2);
                    totalSelectedBoxes++;}catch (NullPointerException ex){ex.printStackTrace();}
            }
        }
        else{
            imageView.setImageResource(R.drawable.o);

            if(checkplayerWin()){

                win win = new win(game.this,   "O has WON The Match", game.this);
                win.setCancelable(false);
                win.show();
            }


            else if(selectedBoxPosition==9){
                win win = new win(game.this,"It is A DRAW!", game.this);
                win.setCancelable(false);
                win.show();
            }

            else{
                try{
                    changeplayerTurn(1);
                    totalSelectedBoxes++;}catch (NullPointerException ex){ex.printStackTrace();}
            }
        }
    }
    private void changeplayerTurn(int currentplayerTurn){
        playerTurn = currentplayerTurn;
        if(playerTurn==1){
            try{
                player1layout.setBackgroundResource(R.drawable.border);
                player2layout.setBackgroundResource(R.drawable.border);}
            catch(NullPointerException ex){ex.printStackTrace();}
        }
        else{
            try{
                player2layout.setBackgroundResource(R.drawable.border);
                player1layout.setBackgroundResource(R.drawable.border);}
            catch (NullPointerException ex){ex.printStackTrace();}
        }

    }
    private boolean checkplayerWin(){
        boolean response = false;
        for(int i = 0;i<combinationsList.size();i++){;
            final int[] combination = combinationsList.get(i);

            if(boxpositions[combination[0]] == playerTurn && boxpositions[combination[1]]==playerTurn && boxpositions[combination[2]]==playerTurn){
                response = true;
            }

        }
        return response;
    }

    private boolean isBoxSelectable(int boxposition){

        boolean response = false;
        if(boxpositions[boxposition]==0){
            response=true;

        }
        return response;
    }
    public void restartmatch() {
        boxpositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn = 1;
        totalSelectedBoxes = 1;
        box1.setImageResource(R.drawable.transparentback1);
        box2.setImageResource(R.drawable.transparentback1);
        box3.setImageResource(R.drawable.transparentback1);
        box4.setImageResource(R.drawable.transparentback1);
        box5.setImageResource(R.drawable.transparentback1);
        box6.setImageResource(R.drawable.transparentback1);
        box7.setImageResource(R.drawable.transparentback1);
        box8.setImageResource(R.drawable.transparentback1);
        box9.setImageResource(R.drawable.transparentback1);

    }
    }
