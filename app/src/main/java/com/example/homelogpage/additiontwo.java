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

public class additiontwo extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3, btn4;
    public Button button;
    public Button button1;
    public Button button2;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_two);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        btn1 = findViewById(R.id.addtwocor);
        btn2 = findViewById(R.id.addtwowro3);
        btn3 = findViewById(R.id.addtwowro2);
        btn4 = findViewById(R.id.addtwowro1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additiontwo.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest2").setValue(10);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additiontwo.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest2").setValue(0);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additiontwo.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest2").setValue(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(additiontwo.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("addquest2").setValue(0);
            }
        });

        button = (Button) findViewById(R.id.backtoaddone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(additiontwo.this, additionone.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button1 = (Button) findViewById(R.id.addtocontent);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(additiontwo.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.addtwotoaddthree);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = db.getReference().child("pievalue");
                node.child(key).child("addquest2").setValue(1);
                Intent intent = new Intent(additiontwo.this, additionthree.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

    }
}