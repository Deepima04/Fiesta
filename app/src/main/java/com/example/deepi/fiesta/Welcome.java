package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread timerThread = new Thread(){

            public void run(){

                try {
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent=new Intent(Welcome.this,Login.class);
                    startActivity(intent);

                }}
        };





        timerThread.start();


    }





    protected void onPause(){
        super.onPause();
        finish();
    }

}
