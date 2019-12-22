package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    EditText username_EditTXT;
    EditText password_EditTXT;
    private static String username="admin";
    private static String password="1234";




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         username_EditTXT=(EditText) findViewById(R.id.username_editText_ID);
         password_EditTXT=(EditText) findViewById(R.id.password_editText_ID);


        /**
         * Login Button
         */
        Button login=(Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String entered_username=username_EditTXT.getText().toString();
                String entered_password=password_EditTXT.getText().toString();

                 if((username.equals(entered_username)) && (password.equals(entered_password)))
                 {
                     Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                     startActivity(intent);
                     finish();
                 }
                 else
                     {
                         username_EditTXT.setText("");
                         password_EditTXT.setText("");
                         Toast.makeText(LoginActivity.this, "Wrong Username or Password", Toast.LENGTH_LONG).show();
                     }


            }
        });





    }  //End onCreate();



} //END Class
