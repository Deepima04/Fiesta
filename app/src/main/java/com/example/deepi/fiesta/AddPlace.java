package com.example.deepi.fiesta;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlace extends AppCompatActivity {



    FiestaDBManager fdm=null;
    SQLiteDatabase db=null;
    EditText place;
    String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        Log.d("test","created page");

        place=(EditText)findViewById(R.id.place);
        fdm=new FiestaDBManager(this);
        p=place.getText().toString();
        Log.d("test","end onCreate");

    }



    public void place_add(View v)
    {

        Log.d("test","add Method");
        fdm.openDB();
        String placename=place.getText().toString();
        FiestaPlace hc=new FiestaPlace();
        hc.setPname(placename);

        long l=fdm.addPlaceData(hc);
        if(l>0)
        {
            Log.d("test","addData:"+l);
            Toast.makeText(this,""+l+"inserted successfully", Toast.LENGTH_LONG).show();
        }
        fdm.closeDB();

        place.setText("");

    }
}
