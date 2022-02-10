package com.example.recyclerviewimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recyclerviewimplementation.databinding.ActivityDetailBinding;

import java.lang.String;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_detail);

        Bundle bundle=getIntent().getExtras();

        String uId=bundle.getString("uId");
        String Id=bundle.getString("jId");
        String Title=bundle.getString("jTitle");
        String Body= bundle.getString("jBody");

        binding.id1.setText(uId);
        binding.id2.setText(Id);
        binding.id3.setText(Title);
        binding.id4.setText(Body);


    }
}