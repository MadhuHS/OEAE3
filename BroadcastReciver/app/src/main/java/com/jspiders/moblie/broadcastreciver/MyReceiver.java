package com.jspiders.moblie.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    static NetworkInfo networkInfo;

    public MyReceiver()
    {

    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context,"Phone mode changed",Toast.LENGTH_SHORT).show();

       ConnectivityManager manager =
               (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
       networkInfo = manager.getActiveNetworkInfo();

    }

    public static NetworkInfo isOnline()
    {
        return networkInfo ;
    }
}
