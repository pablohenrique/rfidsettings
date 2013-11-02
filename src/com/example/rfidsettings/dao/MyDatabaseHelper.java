package com.example.rfidsettings.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
	public final static String EMP_TABLE="Tags"; // name of table 
	
	public final static String EMP_NAME="Name";  // name of employee
	public final static String EMP_3G= "ThreeG";  // name of employee
	public final static String EMP_BT="BT";  // name of employee
	public final static String EMP_WIFI="Wifi";  // name of employee
	public final static String EMP_VOLUME="Volume";  // name of employee
	public final static String EMP_VIBRATE="Vibrate";  // name of employee
	public final static String EMP_TAGID="TagID";  // name of employee
	
    private static final String DATABASE_NAME = "MyTags";
    private static final int DATABASE_VERSION = 2;
    // Database creation sql statement
    //private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " + EMP_TABLE + " (TagID VARCHAR(50) PRIMARY KEY, Name VARCHAR(50), ThreeG Boolean, BT Boolean, Wifi Boolean, Volume Boolean, Vibrate Boolean)";
    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " + EMP_TABLE + " (TagID VARCHAR(50) PRIMARY KEY, Name VARCHAR(50), ThreeG Integer, BT Integer, Wifi Integer, Volume Integer, Vibrate Integer)";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
            int newVersion) {
        Log.w(MyDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }
}