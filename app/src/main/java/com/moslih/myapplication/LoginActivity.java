package com.moslih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        connect = findViewById(R.id.connect);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //Toast.makeText(LoginActivity.this, "Connected", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, EtudiantActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Login or Password is incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
