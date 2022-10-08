package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button signUp;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        signUp = findViewById(R.id.btnSignUp);
        logIn = findViewById(R.id.btnLogin);

        boolean userLoggedIn = FirebaseAuth.getInstance().getCurrentUser() != null;
        if (userLoggedIn) {
            startActivity(new Intent(MainActivity.this, StartActivity.class));
        } else {
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, SignUp.class));
                }
            });
            logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, login.class));
                    finish();
                }
            });
        }
    }
}