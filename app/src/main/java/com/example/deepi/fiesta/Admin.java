package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }



    public void add_place(View v)
    {
        Intent j=new Intent(Admin.this,AddPlace.class);
        startActivity(j);

    }

    public void add_venue(View v)
    {

    }
}
