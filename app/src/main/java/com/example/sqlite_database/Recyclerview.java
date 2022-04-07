package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqlite_database.Adapter.RecyclerViewAdapter;
import com.example.sqlite_database.Classes.RecyclerItemClickListener;
import com.example.sqlite_database.Models.RecipeModel;

import java.util.ArrayList;

public class Recyclerview extends AppCompatActivity {

    RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerview= findViewById(R.id.recview1);
        ArrayList<RecipeModel> list=new ArrayList<>();
        list.add(new RecipeModel(R.drawable.burger1,"burger"));
        list.add(new RecipeModel(R.drawable.burger1,"burger"));

        list.add(new RecipeModel(R.drawable.meal1,"meal"));
        list.add(new RecipeModel(R.drawable.noodles1,"noodles"));
        list.add(new RecipeModel(R.drawable.ny_food,"newyorkfood"));
        list.add(new RecipeModel(R.drawable.omlette1,"omlette"));
        list.add(new RecipeModel(R.drawable.salad1,"salad"));
        list.add(new RecipeModel(R.drawable.south_indian1,"southindian"));
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(list,this);
        recyclerview.setAdapter(adapter);


        //now use accordingly linear layout manager or grid layour manage or staggered layout manager


//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this); //by def verticle
//        recyclerview.setLayoutManager(linearLayoutManager);



        //to get horizontal
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false); //chnage to true n see what happens
//        recyclerview.setLayoutManager(linearLayoutManager);



        //Grid layout
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
//        recyclerview.setLayoutManager((gridLayoutManager));


        //staggered layout
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);




        //click listener
        recyclerview.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerview, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Recyclerview.this, "recyclerView :"+String.valueOf(position)+" clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(Recyclerview.this, "recyclerView"+String.valueOf(position)+" long clicked", Toast.LENGTH_SHORT).show();

            }
        }

        ));










    }
}