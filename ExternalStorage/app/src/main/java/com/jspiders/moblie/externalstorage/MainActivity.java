package com.jspiders.moblie.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputet;
    Button savebtn,readbtn;
    TextView outputtv;
    FileWriter writer;
    File dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputet =(EditText) findViewById(R.id.etinputmessage);
        savebtn =(Button) findViewById(R.id.btnsave);
        readbtn =(Button) findViewById(R.id.btnread);
        outputtv = (TextView) findViewById(R.id.tvoutput);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dir = new File(Environment.getExternalStorageDirectory(),"MyDir");
                dir.mkdir();

                File file = new File(dir,"ExternalStorage");

                try
                {
                    String data = inputet.getText().toString();
                    writer = new FileWriter(file);
                    writer.write(data);
                    Toast.makeText(MainActivity.this,dir.getAbsolutePath(),Toast.LENGTH_SHORT).show();
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

                finally
                {
                    try
                    {
                        writer.flush();
                        writer.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }




            }
        });


        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               File file = new File(dir,"ExternalStorage");
                try
                {
                    FileInputStream fis = new FileInputStream(file);
                }

                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        });





    }
}
