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

public class additionone extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3, btn4;
    public Button button;
    public Button button2;
    public Button button3;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_one);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        btn1 = findViewById(R.id.addonecor);
        btn2 = findViewById(R.id.addonewrong1);
        btn3 = findViewById(R.id.addonewrong2);
        btn4 = findViewById(R.id.addonewrong3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additionone.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest1").setValue(10);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additionone.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest1").setValue(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additionone.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest1").setValue(0);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additionone.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest1").setValue(0);
            }
        });

        button = (Button) findViewById(R.id.backtocontent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(additionone.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.addonetotwo);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = db.getReference().child("pievalue");
                node.child(key).child("addquest1").setValue(1);
                Intent intent = new Intent(additionone.this, additiontwo.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.addotocontent);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(additionone.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
    }
}