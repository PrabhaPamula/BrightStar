package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class comparisionthree extends AppCompatActivity {

    public Button button;
    public Button button2;
    public Button button3;
    AppCompatImageButton btn1, btn2, btn3;
    TextView result;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparision_three);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        button = (Button) findViewById(R.id.comthreetocontent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(comparisionthree.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.finshcom);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = db.getReference().child("pievalue");
                node.child(key).child("compquest3").setValue(1);
                Intent intent = new Intent(comparisionthree.this, mathscontent.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.comthreeto2);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(comparisionthree.this, comparisiontwo.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.comthreecor);
        btn2 = findViewById(R.id.comthreewro1);
        btn3 = findViewById(R.id.comthreewro2);
        result = (TextView) findViewById(R.id.result3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(comparisionthree.this, "Right Answer", Toast.LENGTH_SHORT).show();
                String res = "<";
                result.setText(res);
                result.setVisibility(View.VISIBLE);
                node.child(key).child("Maths marks").child("compquest3").setValue(10);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(comparisionthree.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("compquest3").setValue(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(comparisionthree.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                node.child(key).child("Maths marks").child("compquest3").setValue(0);
            }
        });
    }
}