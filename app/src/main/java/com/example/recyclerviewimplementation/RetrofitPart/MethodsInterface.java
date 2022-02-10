package com.example.recyclerviewimplementation.RetrofitPart;

import com.example.recyclerviewimplementation.Model.Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MethodsInterface {
    @GET("posts")
    Call<ArrayList<Model>> getAllData();
}
