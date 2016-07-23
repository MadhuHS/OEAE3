package com.jspiders.moblie.studentsinfoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.RealmResults;

/**
 * Created by user on 15/07/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {

    Context ctx;
    RealmResults<Student> results;

    RecyclerViewAdapter(Context ctx, RealmResults<Student> results)
    {
        this.ctx = ctx;
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View rowview  = LayoutInflater.from(ctx).inflate(R.layout.row,null);

        return new StudentViewHolder(rowview);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        StudentViewHolder studentViewHolder = (StudentViewHolder) holder;
        studentViewHolder.nametv.setText(results.get(position).getName());
        studentViewHolder.idtv.setText(""+results.get(position).getID());
        studentViewHolder.branchtv.setText(results.get(position).getBranch());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}

class StudentViewHolder extends RecyclerView.ViewHolder
{
    ImageView studentpiciv;
    TextView nametv,idtv,branchtv;

    public StudentViewHolder(View rowview)
    {
        super(rowview);
         nametv = (TextView) rowview.findViewById(R.id.tvname);
         idtv = (TextView) rowview.findViewById(R.id.tvid);
         branchtv =(TextView)rowview.findViewById(R.id.tvbranch);

    }
}
