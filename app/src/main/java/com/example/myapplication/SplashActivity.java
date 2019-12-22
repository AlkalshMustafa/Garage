package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Timer timer;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer (); //start the timer
    }





    //______________________________________Timer Task_____________________________________________

    // Timer Part 1
    public void startTimer ()
    {
        timer =new Timer();
        timer.schedule(new UpdateTask(), 3000,1000); //will set off each  seconds  (20 seconds=20000)
    }



    // Timer Part 2
    class UpdateTask extends TimerTask
    {
        public void run ()
        {
            // to open the main activity
            Intent myIntent=new Intent(SplashActivity.this,LoginActivity.class);
            startActivity(myIntent); //This built-in function used to open a new  activity (it takes only variable type 'Intent')
            timer.cancel();
            finish();
        }
    }
    //______________________________________Timer Task End_________________________________________






}
