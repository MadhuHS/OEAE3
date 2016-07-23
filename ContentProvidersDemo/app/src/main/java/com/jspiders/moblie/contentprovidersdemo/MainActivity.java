package com.jspiders.moblie.contentprovidersdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView contactsListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsListView = (ListView) findViewById(R.id.lvcontacts);


        ContentResolver cr = getContentResolver();

        Cursor cursor = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

        String[] columns ={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                           ,ContactsContract.CommonDataKinds.Phone.NUMBER};
        int[] data = {R.id.tvname,R.id.tvnumber};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,R.layout.row,cursor,columns,data,1);
        contactsListView.setAdapter(adapter);

        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
