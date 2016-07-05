package com.jspiders.moblie.servicesdemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends Service {


    @Override
    public void onCreate()
    {
        super.onCreate();
        Toast.makeText(MyIntentService.this,"inside Oncreate()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {

        Toast.makeText(MyIntentService.this,"inside onStartCommand()",Toast.LENGTH_SHORT).show();

       /* for (int i = 0; i < 100; i++)
        {
            try
            {
                Thread.sleep(2000);
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Log.d("DEBUG",""+i);
        }*/

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy()
    {
        Toast.makeText(MyIntentService.this,"inside onDestroy()",Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
