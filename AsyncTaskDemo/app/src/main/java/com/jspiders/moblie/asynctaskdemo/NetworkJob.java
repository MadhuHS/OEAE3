package com.jspiders.moblie.asynctaskdemo;

import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 06/07/2016.
 */
public class NetworkJob extends AsyncTask {

    Button startbtn;
    TextView statustv;
    NotificationCompat.Builder builder;
    NotificationManager manager;
    Context ctx;


    public NetworkJob(Button startbtn, TextView statustv, Context ctx)
    {
        this.startbtn = startbtn;
        this.statustv = statustv;
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        builder = new NotificationCompat.Builder(ctx);
        builder.setContentTitle("Download started");
        builder.setContentText("0%");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setProgress(100,0,false);
        manager = (NotificationManager) ctx.getSystemService(ctx.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());



        statustv.setText("Download started...");
        startbtn.setEnabled(false);
    }

    @Override
    protected Object doInBackground(Object[] objects)
    {
        for (int i = 1; i <=100 ; i++)
        {
            try
            {
                Thread.sleep(200);
                Log.d("JSPIDERS","i value is "+i);
                System.out.println(i);
                Integer i1 = i;
                publishProgress(i1);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);

        Integer i2 = (Integer) values[0];
        statustv.setText(i2+"%");

        builder.setProgress(100,i2,false);
        builder.setContentText(""+i2+"%");
        manager.notify(1,builder.build());
    }


    @Override
    protected void onPostExecute(Object o)
    {
        super.onPostExecute(o);
        Log.d("DEBUG","Task completed");
        statustv.setText("Download completed...");
        builder.setContentText("Download completed...");
        manager.notify(1,builder.build());
        startbtn.setEnabled(true);
    }
}
