package com.example.joe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);

    }
    public void onSignupClick(View v) {
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }

    public void onSigninClick(View v) {
        Intent intent = new Intent(MainActivity.this, signin.class);
        startActivity(intent);
    }
}