package com.example.deepi.fiesta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Deepi on 2/10/2017.
 */
public class FiestaHelper extends SQLiteOpenHelper

{
        Context context;

    public FiestaHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(FiestaConstants.LOGIN_CREATE);

        db.execSQL(FiestaConstants.PLACE_QUERY);

        Toast.makeText(context,"place table created", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
