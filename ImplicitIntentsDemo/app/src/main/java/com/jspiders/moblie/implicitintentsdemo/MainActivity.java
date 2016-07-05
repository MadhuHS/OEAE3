package com.jspiders.moblie.implicitintentsdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dailbtn;
    ImageView outputiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailbtn =(Button)findViewById(R.id.btndail);
        outputiv = (ImageView) findViewById(R.id.ivoutput);

        dailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                /*Intent dailintent = new Intent(Intent.ACTION_DIAL);
                dailintent.setData(Uri.parse("tel:"+"6656251555"));
                startActivity(dailintent);*/

                /*Intent webintent = new Intent(Intent.ACTION_VIEW);
                webintent.setData(Uri.parse("http://www.google.com"));
                startActivity(webintent);*/

                Intent camintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivity(camintent);
                startActivityForResult(camintent,1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK) {
            /*Bundle b1 = data.getExtras();
            Bitmap bitmap = (Bitmap) b1.get("data");*/
            
            outputiv.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }

        else
        {
            Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_LONG).show();
        }












    }
}
