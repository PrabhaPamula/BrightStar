package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signuppage extends AppCompatActivity {
    public Button button, button1, button2;
    EditText sign_name, sign_phonenumber, sign_email, sign_username, sign_password;

    FirebaseDatabase db;
    DatabaseReference node;

    private Boolean validateName(){
        String val = sign_name.getText().toString();

        if(val.isEmpty()){
            sign_name.setError("Field cannot be empty");
            return false;
        }
        else{
            sign_name.setError(null);
            return  true;
        }
    }

    private Boolean validateUsername(){
        String val = sign_username.getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            sign_username.setError("Field cannot be empty");
            return false;
        }
        else if(val.length() >= 15){
            sign_username.setError("Username too long");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            sign_username.setError("Spaces not allowed");
            return false;
        }
        else{
            sign_username.setError(null);
            return  true;
        }
    }

    private Boolean validateEmail(){
        String val = sign_email.getText().toString();
        String emailpattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            sign_email.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(emailpattern)){
            sign_email.setError("Invalid email address");
            return false;
        }
        else{
            sign_email.setError(null);
            return  true;
        }
    }

    private Boolean validatePhonenumber(){
        String val = sign_phonenumber.getText().toString();

        if(val.isEmpty()){
            sign_phonenumber.setError("Field cannot be empty");
            return false;
        }
        else{
            sign_phonenumber.setError(null);
            return  true;
        }
    }

    private Boolean validatePassword(){
        String val = sign_password.getText().toString();
        String passwordval = "^" +
                "(?=.*[a-zA-Z])" +      //any character
                "(?=.*[@#$%^&+=])" +    //atleast 1 character
                //"\\A\\w{4,20}\\z" +     //no blank spaces
                ".{4,}" +               //atleast 4 character
                "$";

        if(val.isEmpty()){
            sign_password.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(passwordval)){
            sign_password.setError("Password is too weak");
            return false;
        }
        else{
            sign_password.setError(null);
            return  true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        sign_name = findViewById(R.id.regName);
        sign_phonenumber = findViewById(R.id.regPhonenumber);
        sign_email = findViewById(R.id.regEmail);
        sign_username = findViewById(R.id.regUsername);
        sign_password = findViewById(R.id.regPassword);

        button = (Button) findViewById(R.id.backtohomelog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signuppage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button1 = (Button) findViewById(R.id.signtohome);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = FirebaseDatabase.getInstance();
                node = db.getReference("users");

                if(!validateName() | !validateEmail() | !validatePassword() | !validatePhonenumber() | !validateUsername()){
                    return;
                }
                else{
                    Intent intent = new Intent(signuppage.this, loginpage.class);
                    startActivity(intent);
                }

                //Getting all the values
                String name = sign_name.getText().toString();
                String phonenumber = sign_phonenumber.getText().toString();
                String email = sign_email.getText().toString();
                String username = sign_username.getText().toString();
                String password = sign_password.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, phonenumber, email, username, password);

                node.child(username).setValue(helperClass);

                node = FirebaseDatabase.getInstance().getReference().child("marks");
                node.child(username).child("Maths marks").child("addquest1").setValue(0);
                node.child(username).child("Maths marks").child("addquest2").setValue(0);
                node.child(username).child("Maths marks").child("addquest3").setValue(0);
                node.child(username).child("Maths marks").child("subquest1").setValue(0);
                node.child(username).child("Maths marks").child("subquest2").setValue(0);
                node.child(username).child("Maths marks").child("subquest3").setValue(0);
                node.child(username).child("Maths marks").child("compquest1").setValue(0);
                node.child(username).child("Maths marks").child("compquest2").setValue(0);
                node.child(username).child("Maths marks").child("compquest3").setValue(0);

                node.child(username).child("EVS marks").child("aniquest1").setValue(0);
                node.child(username).child("EVS marks").child("aniquest2").setValue(0);
                node.child(username).child("EVS marks").child("aniquest3").setValue(0);
                node.child(username).child("EVS marks").child("fquestion1").setValue(0);
                node.child(username).child("EVS marks").child("fquestion2").setValue(0);
                node.child(username).child("EVS marks").child("fquest3").setValue(0);
                node.child(username).child("EVS marks").child("hquest1").setValue(0);
                node.child(username).child("EVS marks").child("hquest2").setValue(0);
                node.child(username).child("EVS marks").child("hquest3").setValue(0);

                node.child(username).child("English marks").child("alphabetquest1").setValue(0);
                node.child(username).child("English marks").child("alphabetquest2").setValue(0);
                node.child(username).child("English marks").child("alphabetquest3").setValue(0);
                node.child(username).child("English marks").child("rquest1").setValue(0);
                node.child(username).child("English marks").child("rquest2").setValue(0);
                node.child(username).child("English marks").child("rquest3").setValue(0);
                node.child(username).child("English marks").child("squest1").setValue(0);
                node.child(username).child("English marks").child("squest2").setValue(0);
                node.child(username).child("English marks").child("squest3").setValue(0);

                node = FirebaseDatabase.getInstance().getReference().child("pievalue");
                node.child(username).child("addquest1").setValue(0);
                node.child(username).child("addquest2").setValue(0);
                node.child(username).child("addquest3").setValue(0);
                node.child(username).child("subquest1").setValue(0);
                node.child(username).child("subquest2").setValue(0);
                node.child(username).child("subquest3").setValue(0);
                node.child(username).child("compquest1").setValue(0);
                node.child(username).child("compquest2").setValue(0);
                node.child(username).child("compquest3").setValue(0);

                node.child(username).child("aniquest1").setValue(0);
                node.child(username).child("aniquest2").setValue(0);
                node.child(username).child("aniquest3").setValue(0);
                node.child(username).child("fquestion1").setValue(0);
                node.child(username).child("fquestion2").setValue(0);
                node.child(username).child("fquest3").setValue(0);
                node.child(username).child("hquest1").setValue(0);
                node.child(username).child("hquest2").setValue(0);
                node.child(username).child("hquest3").setValue(0);

                node.child(username).child("alphabetquest1").setValue(0);
                node.child(username).child("alphabetquest2").setValue(0);
                node.child(username).child("alphabetquest3").setValue(0);
                node.child(username).child("rquest1").setValue(0);
                node.child(username).child("rquest2").setValue(0);
                node.child(username).child("rquest3").setValue(0);
                node.child(username).child("squest1").setValue(0);
                node.child(username).child("squest2").setValue(0);
                node.child(username).child("squest3").setValue(0);


            }
        });

        button2 = (Button) findViewById(R.id.signtolog);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signuppage.this, loginpage.class);
                startActivity(intent);
            }
        });

    }
}