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

public class englishrhymone extends AppCompatActivity {

    public Button button;
    public Button button2;
    public Button button3;
    AppCompatButton btn1, btn2, btn3, btn4;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_englishrhymone);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        button = (Button) findViewById(R.id.backtoindexeng);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(englishrhymone.this, english_index.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.exitrhymone);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(englishrhymone.this, english_index.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.rhyoneto2);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = db.getReference().child("pievalue");
                node.child(key).child("rquest1").setValue(1);
                Intent intent = new Intent(englishrhymone.this, rhyming_two.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.rhymonecor);
        btn2 = findViewById(R.id.rhymonewro1);
        btn3 = findViewById(R.id.rhymonewro2);
        btn4 = findViewById(R.id.rhymonewro3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(englishrhymone.this, "Right Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("English marks").child("rquest1").setValue(10);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(englishrhymone.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("English marks").child("rquest1").setValue(0);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(englishrhymone.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("English marks").child("rquest1").setValue(0);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(englishrhymone.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("English marks").child("rquest1").setValue(0);

            }
        });
    }
}