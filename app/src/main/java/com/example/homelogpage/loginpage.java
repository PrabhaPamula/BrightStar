package com.example.homelogpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginpage extends AppCompatActivity {
    public Button button1, button2, button3;
    EditText login_Username, login_Password;

    private Boolean validateUsername(){
        String val = login_Username.getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            login_Username.setError("Field cannot be empty");
            return false;
        }
        else{
            login_Username.setError(null);
            return  true;
        }
    }

    private Boolean validatePassword(){
        String val = login_Password.getText().toString();
        if(val.isEmpty()){
            login_Password.setError("Field cannot be empty");
            return false;
        }
        else{
            login_Password.setError(null);
            return  true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        button1 = (Button) findViewById(R.id.loginbackbtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.logtoselectrole);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() | !validatePassword()) {
                    return;
                }
                else{
                    isUser();
                }
            }
        });

        button3 = (Button) findViewById(R.id.logtosign);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this, signuppage.class);
                startActivity(intent);
            }
        });

        login_Password = findViewById(R.id.logPassword);
        login_Username = findViewById(R.id.logUsername);

    }

    private void isUser() {

        String userEnteredUsername = login_Username.getText().toString().trim();
        String userEnteredPassword = login_Password.getText().toString().trim();

        DatabaseReference node = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = node.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    login_Username.setError(null);

                    String passwordfromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    assert passwordfromDB != null;
                    if(passwordfromDB.equals(userEnteredPassword)){

                        login_Password.setError(null);

                        String usernamefromDB = snapshot.child(userEnteredUsername).child("username").getValue(String.class);

                        Intent intent = new Intent(loginpage.this, selectrole.class);
                        intent.putExtra("key",userEnteredUsername);
                        startActivity(intent);

                    }
                    else{
                        login_Password.setError("Wrong Password");
                        login_Password.requestFocus();
                    }
                }
                else {
                    login_Username.setError("No such user exists");
                    login_Username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}