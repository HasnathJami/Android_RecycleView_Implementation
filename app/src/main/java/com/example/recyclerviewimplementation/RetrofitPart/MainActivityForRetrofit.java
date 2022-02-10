package com.example.recyclerviewimplementation.RetrofitPart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.recyclerviewimplementation.Adapter.AdapterClass;
import com.example.recyclerviewimplementation.Model.Model;
import com.example.recyclerviewimplementation.databinding.ActivityMainBinding;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityForRetrofit extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Model> list=new ArrayList<>(); // new ArrayList<>() is must
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.recyclerViewId.setHasFixedSize(true);
        binding.recyclerViewId.setLayoutManager(new LinearLayoutManager(this));

        MethodsInterface methodsInterface=RetrofitClass.getRetrofitInstance().create(MethodsInterface.class);
        Call<ArrayList<Model>> call=methodsInterface.getAllData();
        call.enqueue(new Callback<ArrayList<Model>>() {
            @Override
            public void onResponse(Call<ArrayList<Model>> call, Response<ArrayList<Model>> response) {

                ArrayList<Model> m=response.body();

                for(Model i:m)
                {
                    String st1=i.getUserId();
                    String st2=i.getId();
                    String st3=i.getTitle();
                    String st4=i.getBody();

                    Model model=new Model(st1,st2,st3,st4);
                    list.add(model);

                }

                AdapterClass adapterClass=new AdapterClass(MainActivityForRetrofit.this,list);
                binding.recyclerViewId.setAdapter(adapterClass);


            }

            @Override
            public void onFailure(Call<ArrayList<Model>> call, Throwable t) {

            }
        });


    }

}