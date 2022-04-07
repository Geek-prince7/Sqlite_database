package com.example.sqlite_database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button insert,update,delete,view;
EditText name,email,pwd,phone,age;
DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pwd=findViewById(R.id.password);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        insert=findViewById(R.id.insert);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        view=findViewById(R.id.viewdata);
        db=new DBHelper(MainActivity.this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm=name.getText().toString();
                String em=email.getText().toString();
                String pass=pwd.getText().toString();
                String phn=phone.getText().toString();
                int ag=Integer.valueOf(age.getText().toString());
                if( db.insert(nm,em,phn,ag,pass))
               {
                   Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
               }
                else
                {
                    Toast.makeText(MainActivity.this, "not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cr=db.viewdata();
                StringBuilder str=new StringBuilder();
                while(cr.moveToNext())
                {
                    str.append(cr.getString(0)+"\n");
                    str.append(cr.getString(1)+"\n");
                    str.append(cr.getString(2)+"\n");
                    str.append(cr.getString(3)+"\n");
                    str.append(cr.getString(4)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("values");
                builder.setMessage(str.toString());
                builder.show();

            }
        });





    }
}