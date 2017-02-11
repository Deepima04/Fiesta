package com.example.deepi.fiesta;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements DialogInterface.OnClickListener{

    FiestaDBManager fdm=null;
    AlertDialog ad=null;

    EditText userid,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid=(EditText)findViewById(R.id.userid);
        password=(EditText)findViewById(R.id.password);
        fdm=new FiestaDBManager(this);

    }

    public void signup(View v)
    {
        Intent j=new Intent(Login.this,Signup.class);
        startActivity(j);

    }

    public void loginbutton(View v)
    {

        fdm.openDB();

        String userName=userid.getText().toString();
        String passwo=password.getText().toString();
        String storedPassword = fdm.getSingleEntry(userName);
        if(userName.length()==0|| password.length()==0)
        {
            showDialog();
        }

        else if(userName.equals("admin")&&passwo.equals("admin"))
        {
            Intent i=new Intent(this,Admin.class);
            startActivity(i);
        }

        else if (passwo.equals(storedPassword)) {
            Toast.makeText(Login.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();

            startActivity(new Intent(getApplicationContext(), HomePage.class));
        }
        else
        {
            Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
        }



    }

    public void showDialog()
    {

        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("info");
        adb.setMessage("Data Required");
        adb.setPositiveButton("ok",this);
        ad=adb.create();
        ad.show();

    }



    @Override
    public void onClick(DialogInterface dialog, int which)
    {

        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(this,"please enter",Toast.LENGTH_LONG).show();
                break;
        }

    }

}
