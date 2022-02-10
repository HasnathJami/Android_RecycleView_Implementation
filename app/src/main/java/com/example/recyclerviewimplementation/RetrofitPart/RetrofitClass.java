package com.example.recyclerviewimplementation.RetrofitPart;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    public static Retrofit retrofit;
    public static String BASE_URL="https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofitInstance()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
