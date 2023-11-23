package com.example.homelogpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    Animation topAnim , bottomAnim ;
    ImageView image;
    TextView Welcome,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.homelogpage);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.homepageanim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.homepageanim2);

        image = findViewById(R.id.homeloglogo);
        Welcome = findViewById(R.id.Welcome);
        desc = findViewById(R.id.desc);


        image.setAnimation(topAnim);
        Welcome.setAnimation(bottomAnim);
        desc.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,loginpage.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}