package com.example.deepi.fiesta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Deepi on 2/10/2017.
 */
public class FiestaDBManager
{
    FiestaHelper fh=null;
    SQLiteDatabase db=null;
    public FiestaDBManager(Context context)
    {
        fh=new FiestaHelper(context,FiestaConstants.DATABASE_NAME,null,1);

    }

    public void openDB()
    {

        db=fh.getWritableDatabase();
    }
    public void closeDB()
    {
        if(db!=null)
            db.close();
    }

    public void insertEntry(String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public String getSingleEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public long addPlaceData(FiestaPlace fp)
    {
        ContentValues cv=new ContentValues();
        cv.put(FiestaConstants.COLUMN_PNAME,fp.getPname());
        long l=db.insert(FiestaConstants.TABLE_PLACE,null,cv);
        return l;
    }


}
