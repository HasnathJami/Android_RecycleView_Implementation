package com.example.recyclerviewimplementation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewimplementation.Adapter.AdapterClass;
import com.example.recyclerviewimplementation.Model.Model;
import com.example.recyclerviewimplementation.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Model> list;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);

        binding.recyclerViewId.setHasFixedSize(true);
        binding.recyclerViewId.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Volley.newRequestQueue(this);
        list=new ArrayList<>();
        fetchData();



    }

    private  void fetchData() {
         String url="https://jsonplaceholder.typicode.com/posts";
         JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
             @Override
             public void onResponse(JSONArray response) {

                 JSONObject obj;
                 String st1,st2,st3,st4;
                 for(int i=0;i<response.length();i++)
                 {
                     try {
                         obj=response.getJSONObject(i);
                         st1=obj.getString("userId");
                         st2=obj.getString("id");
                         st3=obj.getString("title");
                         st4=obj.getString("body");

                         Model model= new Model(st1,st2,st3,st4);
                         list.add(model);



                     } catch (JSONException e) {
                         e.printStackTrace();
                     }

                     AdapterClass adapterClass=new AdapterClass(MainActivity.this,list);
                     binding.recyclerViewId.setAdapter(adapterClass);
                 }

             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 //Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
             }
         });
         requestQueue.add(jsonArrayRequest);
    }
}