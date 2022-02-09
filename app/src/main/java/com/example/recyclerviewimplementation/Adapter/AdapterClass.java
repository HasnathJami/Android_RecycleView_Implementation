package com.example.recyclerviewimplementation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewimplementation.Model.Model;
import com.example.recyclerviewimplementation.R;

import java.util.ArrayList;

public class AdapterClass  extends RecyclerView.Adapter<AdapterClass.viewHolder> {



    private Context context;
    private ArrayList<Model> list;

    public AdapterClass(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    //1. Attach the sample_layout template to the backend and return this to viewHolder class by passing value to the constructor
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.sample_layout,parent,false);
        return new viewHolder(view);
    }

    //3 first of all get the position of first item from the list and set it to the model;
    //then setText to the textViews. Since data's are coming from api through model so call data and fetch data from model.
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model model=list.get(position);
        holder.tv1.setText(model.getUserId().toString());
        holder.tv2.setText(model.getId());
        holder.tv3.setText(model.getTitle());
        holder.tv4.setText(model.getBody());

        //Glide.with(context).load(model.getPoster()).into(holder.imageViewId);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //2 Receive the value of view from onCreate ViewHolder and fetch all the id's from frontend  for the further works.
    public class viewHolder extends RecyclerView.ViewHolder{

        TextView tv1,tv2,tv3,tv4;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.textView1Id);
            tv2=itemView.findViewById(R.id.textView2Id);
            tv3=itemView.findViewById(R.id.textView3Id);
            tv4=itemView.findViewById(R.id.textView4Id);
        }
    }
}
