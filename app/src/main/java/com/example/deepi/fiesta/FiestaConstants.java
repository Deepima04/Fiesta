package com.example.deepi.fiesta;

/**
 * Created by Deepi on 2/10/2017.
 */
public class FiestaConstants
{

    public static final String DATABASE_NAME="Fiesta";
    public static final String DATABASE_VERSION="1";

    static final String LOGIN_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME text,PASSWORD text); ";


    public static final String TABLE_PLACE="place";
    public static final String COLUMN_PID="pid";
    public static final String COLUMN_PNAME="pname";

    public static final String PLACE_QUERY="create table "+TABLE_PLACE+"("+COLUMN_PID+" integer primary key autoincrement,"+COLUMN_PNAME+" text)";


}
