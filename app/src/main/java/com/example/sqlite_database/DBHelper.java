package com.example.sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "dbone.db", null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Student(name TEXT,email TEXT Primary key,pwd TEXT,phone TEXT,age int) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Boolean insert(String name,String email,String phone,int age,String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues  cv=new ContentValues();
        cv.put("name",name);
        cv.put("email",email);

        cv.put("phone",phone);
        cv.put("age",age);
        cv.put("pwd",pass);
        long result=db.insert("Student",null,cv);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }



    }
    //update name using email
    public Boolean update(String mail,String name )
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        Cursor cr=db.rawQuery("select * from Student where email=?",new String[]{mail});
        if(cr.getCount()>0)
        {
            long result= db.update("Student",cv,"email=?",new String[]{mail});
            if(result<0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }


    }


    //delete a tupple based on email
    public Boolean delete(String mail)
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Student where email=?",new String[]{mail});
        if(cr.getCount()>0)
        {
            long result= db.delete("Student","email=?",new String[]{mail});
            if(result<0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }


    }
    public Boolean validate(String em,String pwd)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery("select * from Student where email=? and pwd=?",new String[]{em,pwd});
        if(cr.getCount()>0)
        {
            return true;
        }
        return false;

    }
    public Cursor viewdata()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery("select * from Student",null);
        return cr;
    }
}
