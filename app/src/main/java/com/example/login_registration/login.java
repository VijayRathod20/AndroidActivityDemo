package com.example.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setupListeners();

    }
    private void setupUI() {
        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        register = findViewById(R.id.signup);
        login = findViewById(R.id.login);
    }
    private  void setupListeners(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUsername();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(com.example.login_registration.login.this,MainActivity.class);
                startActivity(i1);

            }
        });
    }
    void checkUsername(){
        boolean isValid = true;
        if(isEmpty(username)){
            username.setError("username required!");
            isValid = false;
        }else {
            if(!isEmail(username)){
                username.setError("Enter valid Email!");
            }
        }
        if(isValid){
            String txtuser = username.getText().toString();
            String txtpass = password.getText().toString();
            if(txtuser.equals("vijay@gmail.com") && txtpass.equals("vijay123")){
                Intent i = new Intent(login.this,Welcome.class);
                startActivity(i);
                this.finish();
            }
        }
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return  (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}