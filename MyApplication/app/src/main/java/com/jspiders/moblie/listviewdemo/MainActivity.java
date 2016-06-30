package com.jspiders.moblie.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView phoneslv;
    GridView phonesgv;
    Spinner phomesspn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final String[] phones = {"HTC","MOTO","Samsung","Nexus","OPPO","Sony","Asus","Lenovo","MI","MICROMAX","LG"};
        phoneslv =(ListView) findViewById(R.id.lvphones);
        phonesgv = (GridView) findViewById(R.id.gvphones);
        phomesspn = (Spinner) findViewById(R.id.spnphones);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,phones);
        phoneslv.setAdapter(adapter);
       /* phonesgv.setAdapter(adapter);*/
        phomesspn.setAdapter(adapter);

        phoneslv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Toast.makeText(MainActivity.this,phones[position],Toast.LENGTH_SHORT).show();
            }
        });

        phomesspn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                Toast.makeText(MainActivity.this,phones[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

























    }
}
