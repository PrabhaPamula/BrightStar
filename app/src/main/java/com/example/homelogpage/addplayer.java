package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class addplayer extends AppCompatActivity {
    public Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_addplayer);

        final EditText player1 = findViewById(R.id.player1name);
        final EditText player2 = findViewById(R.id.player2name);
        final Button Start = findViewById(R.id.startbutton);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String getplayer1name = player1.getText().toString();
                final String getplayer2name = player2.getText().toString();

                if(getplayer1name.isEmpty() || getplayer2name.isEmpty()){
                    Toast.makeText(addplayer.this,"Please Enter Name!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(addplayer.this, game.class);
                    intent.putExtra("player1",getplayer1name);
                    intent.putExtra("player2",getplayer2name);
                    startActivity(intent);


                }
            }
        });
        back = (Button) findViewById(R.id.gametokid);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addplayer.this, kidsection.class);

                startActivity(intent);
            }
        });

    }
}



