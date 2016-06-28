package com.jspiders.moblie.loginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText usernameet,passwordet;
    Button loginbtn;

    String username = "jspiders";
    String password = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameet = (EditText) findViewById(R.id.etusername);
        passwordet = (EditText) findViewById(R.id.etpassword);
        loginbtn   = (Button) findViewById(R.id.btnlogin);

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
                    Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
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
        });
    }
}
