package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class parentsec extends AppCompatActivity {
    public Button button;
    public ImageButton displaygraph,linegraph,portiongraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentsec);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        button = (Button) findViewById(R.id.parenttolog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentsec.this, selectrole.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        displaygraph = (ImageButton) findViewById(R.id.parentsec_proceed1);
        displaygraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentsec.this,threegraphs.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        linegraph= (ImageButton)  findViewById(R.id.parentsec_proceed2);
        linegraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentsec.this,LineChart.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        portiongraph = (ImageButton) findViewById(R.id.parentsec_proceed3);
        portiongraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentsec.this,pieportion.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
    }
}