package com.jspiders.moblie.movieratingsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/07/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter {

    Context ctx;
    ArrayList<Response.Search> searchlist;


    CustomAdapter(ArrayList<Response.Search> searchlist, Context ctx)
    {
        this.ctx = ctx;
        this.searchlist = searchlist;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(ctx).inflate(R.layout.row,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder)holder;
        Picasso.with(ctx).load(searchlist.get(position).getPoster()).into(((MyViewHolder) holder).webposteriv);
        myViewHolder.titletv.setText(searchlist.get(position).getTitle());
        myViewHolder.extratv.setText(searchlist.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return searchlist.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder
{
    public ImageView webposteriv;
    public TextView titletv,extratv;

    public MyViewHolder(View itemView)
    {
        super(itemView);

        webposteriv = (ImageView) itemView.findViewById(R.id.ivwebposter);
        titletv = (TextView) itemView.findViewById(R.id.tvtitle);
        extratv = (TextView) itemView.findViewById(R.id.tvextra);


    }
}










