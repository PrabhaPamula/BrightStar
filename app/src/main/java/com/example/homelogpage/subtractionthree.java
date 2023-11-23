package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class subtractionthree extends AppCompatActivity {
    public Button button1;
    public Button button2;
    public Button button3;
    AppCompatButton btn1, btn2, btn3, btn4;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_three);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        button1 = (Button) findViewById(R.id.finshsub);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = db.getReference().child("pievalue");
                node.child(key).child("subquest3").setValue(1);
                Intent intent = new Intent(subtractionthree.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.subthreetocontent);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subtractionthree.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.subthreeto2);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subtractionthree.this, subtractiontwo.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.subthreecor);
        btn2 = findViewById(R.id.subthreewro1);
        btn3 = findViewById(R.id.subthreewro2);
        btn4 = findViewById(R.id.subthreewro3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(subtractionthree.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("subquest3").setValue(10);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(subtractionthree.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("subquest3").setValue(0);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(subtractionthree.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("subquest3").setValue(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(subtractionthree.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("subquest3").setValue(0);
            }
        });

    }
}