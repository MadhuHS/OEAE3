package com.jspiders.moblie.movieratingsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieslv = (ListView) findViewById(R.id.lvmovies);
        names = new ArrayList<String>();
        ivposter = (ImageView) findViewById(R.id.ivposter);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://www.omdbapi.com/?s=Batman&page=2", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String jsonresponse = new String(responseBody);
                Log.d("DEBUG",jsonresponse);

                Gson gson = new Gson();

                Response response1 = gson.fromJson(jsonresponse,Response.class);
                ArrayList<Response.Search> list = (ArrayList<Response.Search>) response1.getSearch();


                for (Response.Search s : list)
                {
                    names.add(s.getTitle());
                    //Log.d("DEBUG", s.getTitle());
                }


                adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,names);
                movieslv.setAdapter(adapter);

                Picasso.with(MainActivity.this).load(list.get(0).getPoster()).into(ivposter);




            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
