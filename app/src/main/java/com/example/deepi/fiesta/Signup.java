package com.example.deepi.fiesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    FiestaDBManager fdm=null;

    EditText txtname, txtpass, txtconpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        txtname = (EditText) findViewById(R.id.txtname);
        txtpass = (EditText) findViewById(R.id.txtpass);
        txtconpass=(EditText)findViewById(R.id.txtconpass);

        fdm=new FiestaDBManager(this);

    }

    public void createAccount(View v)
    {
        fdm.openDB();
        String name=txtname.getText().toString();
        String pass=txtpass.getText().toString();
        String conpass=txtconpass.getText().toString();

        if(name.equals("")||pass.equals("")||conpass.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
            return;
        }
        if(!pass.equals(conpass))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            // Save the Data in Database
            fdm.insertEntry(name,pass);
            Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
        }
        fdm.closeDB();

    }



}
