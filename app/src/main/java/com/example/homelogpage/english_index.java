package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class english_index extends AppCompatActivity {

    public Button button;
    public Button button2;
    public ImageButton next;
    public ImageButton next2;
    public ImageButton next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_index);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        button = (Button) findViewById(R.id.exiteng);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(english_index.this, subjectspage.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.engtocontent);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(english_index.this, subjectspage.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next = (ImageButton) findViewById(R.id.engtorhy);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(english_index.this, englishrhymone.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next2 = (ImageButton) findViewById(R.id.engtoalp);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(english_index.this, Alphabets_One.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next3 = (ImageButton) findViewById(R.id.engtosen);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(english_index.this, sentence_formation_one.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });


    }
}