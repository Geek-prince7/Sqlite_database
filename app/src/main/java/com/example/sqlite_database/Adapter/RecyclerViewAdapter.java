package com.example.sqlite_database.Adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_database.Models.RecipeModel;
import com.example.sqlite_database.R;
import com.example.sqlite_database.Recyclerview;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {

    ArrayList<RecipeModel> list;
    Context context;

    public RecyclerViewAdapter(ArrayList<RecipeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        RecipeModel rcp=list.get(position);
        holder.img.setImageResource(rcp.getPic());
        holder.tv.setText(rcp.getText());
        String pos=String.valueOf(position);



        //image view click
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,pos, Toast.LENGTH_SHORT).show();
            }
        });


        //text view click
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "text"+pos, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {


        ImageView img;
        TextView tv;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView2);
            tv=itemView.findViewById(R.id.textView5);



        }
    }
}
