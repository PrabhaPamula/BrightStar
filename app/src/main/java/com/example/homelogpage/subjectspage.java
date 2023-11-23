package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;

public class subjectspage extends AppCompatActivity {
    public ImageButton next;
    public ImageButton next2;
    public ImageButton next3;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectspage);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        next = (ImageButton) findViewById(R.id.subtomath);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectspage.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next2 = (ImageButton) findViewById(R.id.subtoeng);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectspage.this, english_index.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        next3 = (ImageButton) findViewById(R.id.subtogk);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectspage.this, evscontents.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button = (Button) findViewById(R.id.backtokidsec);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectspage.this, kidsection.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
    }
}