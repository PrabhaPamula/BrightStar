package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;

public class kidsection extends AppCompatActivity {
    public Button button;
    public ImageButton next;
    public ImageButton next2;
    public ImageButton next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_sec);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");


        button = (Button) findViewById(R.id.kidtolog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kidsection.this, selectrole.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next = (ImageButton) findViewById(R.id.kidtolearn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kidsection.this, subjectspage.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next3 = (ImageButton) findViewById(R.id.kidsecnext3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kidsection.this, pieportion.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next2 = (ImageButton) findViewById(R.id.kidsectogame);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kidsection.this, addplayer.class);
                startActivity(intent);
            }
        });

    }
}