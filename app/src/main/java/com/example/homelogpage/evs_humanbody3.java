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

public class evs_humanbody3 extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3, btn4;
    public Button button;
    public Button button1;
    public Button button2;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evs_humanbody3);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        button = (Button) findViewById(R.id.humthreeto2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs_humanbody3.this, evs_humanbody2.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button1 = (Button) findViewById(R.id.exithum3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(evs_humanbody3.this, evscontents.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.finshhum);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = db.getReference().child("pievalue");
                node.child(key).child("hquest3").setValue(1);
                Intent intent = new Intent(evs_humanbody3.this, evscontents.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.humthreecor);
        btn2 = findViewById(R.id.humthreewro1);
        btn3 = findViewById(R.id.humthreewro2);
        btn4 = findViewById(R.id.humthreewro3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(evs_humanbody3.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("EVS marks").child("hquest3").setValue(10);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(evs_humanbody3.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("EVS marks").child("hquest3").setValue(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(evs_humanbody3.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("EVS marks").child("hquest3").setValue(0);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(evs_humanbody3.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("EVS marks").child("hquest3").setValue(0);
            }
        });
    }
}