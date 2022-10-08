package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ims.RegistrationManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button btnSignUp;
    private Button loginBtn;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignUp = findViewById(R.id.btnSignUp);
        email = findViewById(R.id.etEmailAddress);
        password = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.AloginBtn);
        auth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  txt_email = email.getText().toString();
                String txt_Password = password.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_Password)){
                    Toast.makeText(SignUp.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }
                else if(txt_Password.length()<6){
                    Toast.makeText(SignUp.this, "Password Should be of Atleast of 8 Characters", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerUser(txt_email, txt_Password);
                }
                {

                }
            }

            private void registerUser(String email, String password) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Signing Up", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this, StartActivity.class));
//                            finish();
                        }
                        else{
                            Toast.makeText(SignUp.this, "Signing Up", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, login.class));
            }
        });

    }
}