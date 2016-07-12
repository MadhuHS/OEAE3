package com.jspiders.moblie.movieratingsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView movieslv;
    ArrayList<String> names;
    ArrayAdapter adapter;
    ImageView ivposter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recyclerview);

        recyclerView =(RecyclerView)findViewById(R.id.rvmovlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

      /*  movieslv = (ListView) findViewById(R.id.lvmovies);
        names = new ArrayList<String>();
        ivposter = (ImageView) findViewById(R.id.ivposter);*/

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://www.omdbapi.com/?s=Batman&page=2", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String jsonresponse = new String(responseBody);
                Log.d("DEBUG",jsonresponse);

                Gson gson = new Gson();

                Response response1 = gson.fromJson(jsonresponse,Response.class);
                ArrayList<Response.Search> list = (ArrayList<Response.Search>) response1.getSearch();

                /*adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,names);
                movieslv.setAdapter(adapter);

                Picasso.with(MainActivity.this).load(list.get(0).getPoster()).into(ivposter);
*/
                CustomAdapter customAdapter = new CustomAdapter(list,MainActivity.this);
                recyclerView.setAdapter(customAdapter);




            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
