package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class evscontents extends AppCompatActivity {

    public ImageButton next;
    public ImageButton next1;
    public ImageButton next2;
    public ImageButton next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evscontents);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        next = (ImageButton) findViewById(R.id.evstosub);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evscontents.this, subjectspage.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });


        next1 = (ImageButton) findViewById(R.id.evstoani);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evscontents.this, evs_animals.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });


        next2 = (ImageButton) findViewById(R.id.evstofes);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evscontents.this, evs_festivals.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next3 = (ImageButton) findViewById(R.id.evstohum);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evscontents.this, evs_humanbody1.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
    }
}