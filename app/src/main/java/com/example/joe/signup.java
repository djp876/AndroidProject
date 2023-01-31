package com.example.joe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText username, password, email;
    Button signup, signin;
    TextView textView;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.edit_text_username);
        password = (EditText) findViewById(R.id.edit_text_password);
        email = (EditText) findViewById(R.id.edit_text_email);
        signup = (Button) findViewById(R.id.button_signup);
        textView = findViewById(R.id.text_sigin);
        DB = new DatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String mail = email.getText().toString();

                if(user.equals("")||pass.equals("")||mail.equals(""))
                    Toast.makeText(signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,mail, pass);
                            if(insert==true){
                                Toast.makeText(signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signup.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }

                } }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), signin.class);
                startActivity(intent);
            }
        });
    }
}