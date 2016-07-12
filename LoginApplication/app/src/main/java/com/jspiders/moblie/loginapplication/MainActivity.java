package com.jspiders.moblie.loginapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText usernameet,passwordet;
    Button loginbtn;
    CheckBox rmbrpwdcb;

    String username = "jspiders";
    String password = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameet = (EditText) findViewById(R.id.etusername);
        passwordet = (EditText) findViewById(R.id.etpassword);
        loginbtn   = (Button) findViewById(R.id.btnlogin);
        rmbrpwdcb = (CheckBox) findViewById(R.id.cbrmbrpwd);

       if(readUserdetails()==true)
       {
           Intent intent = new Intent(MainActivity.this,HomeActivity.class);
           startActivity(intent);
       }

        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Editable e1 =  usernameet.getText();
                String entusername = usernameet.getText().toString();
                String entpassword = passwordet.getText().toString();

                if(entusername.equals(username)&& entpassword.equals(password))
                {
                    //Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
                    if(rmbrpwdcb.isChecked())
                    {
                       saveUserdetails(entusername,entpassword);
                    }

                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }

                else if(entusername.length()==0&&entpassword.length()==0)
                {
                    usernameet.setError("enter username");
                    passwordet.setError("enter password");
                }

                else if (entusername.length()!=0&&entpassword.length()==0)
                {
                    passwordet.setError("enter password");
                }

                else if(entusername.length()==0&&entpassword.length()!=0)
                {
                    usernameet.setError("enter username");
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                }


            }
        });}

    public void saveUserdetails(String username,String password)
    {
        //writing data sharedpreferences
        SharedPreferences preferences = getSharedPreferences("userdetails", Context.MODE_PRIVATE);
        preferences.edit().putString("username",username).commit();
        preferences.edit().putString("password",password).commit();
        preferences.edit().putBoolean("saved",true).commit();
    }

    public boolean readUserdetails()
    {
        SharedPreferences preferences = getSharedPreferences("userdetails",Context.MODE_PRIVATE);
        /*String username = preferences.getString("username","na");
        String password = preferences.getString("password","na");
        usernameet.setText(username);
        passwordet.setText(password);*/
       boolean saved = preferences.getBoolean("saved",false);
        return saved;



    }











}
