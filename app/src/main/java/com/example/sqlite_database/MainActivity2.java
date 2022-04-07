package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
DBHelper db;
Button login,Register;
EditText mail,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mail=findViewById(R.id.editTextTextEmailAddress);
        pwd=findViewById(R.id.editTextTextPassword);
        login=findViewById(R.id.login_btn);
        Register=findViewById(R.id.register_btn);
        db=new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em=mail.getText().toString();
                String pass=pwd.getText().toString();
                if(db.validate(em,pass))
                {
                    Toast.makeText(MainActivity2.this, "ok", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity2.this,Recyclerview.class));
                }
                else
                {
                    Toast.makeText(MainActivity2.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
            }
        });

    }
}