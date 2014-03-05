package com.example.rfidsettings.dao;

import java.util.ArrayList;

import com.example.rfidsettings.model.RFIDTag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RFIDTagDAO extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "rfidtags_database.db";
	private static final String TABLE_NAME = "rfidtags";
	private static final String KEY_NAME = "tagid";
    private static final int SCHEMA_VERSION = 1;
    
    private static final String COLUMN_NAMES = "tagid, name, threeg, bluetooth, wifi, volume, vibrate";
    private static final String GETALL = "SELECT "+ COLUMN_NAMES +" FROM " + TABLE_NAME;
    
 
    public RFIDTagDAO(Context context) {
    	super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	try{
	        db.execSQL("CREATE TABLE "
	        		+ TABLE_NAME + " ("
	        		+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
	                + " tagid TEXT,"
	        		+ " name TEXT,"
	                + " threeg INTEGER,"
	        		+ " bluetooth INTEGER,"
	                + " wifi INTEGER,"
	        		+ " volume INTEGER,"
	                + " vibrate INTEGER,"
	        		+ " UNIQUE(tagid) ON CONFLICT REPLACE);");
    	}
    	catch(Exception except){
    		System.out.println("onCreate Database: " + except.toString());
    	}
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
    
    public void update(RFIDTag tag){
		if(this.getWritableDatabase().update(TABLE_NAME, this.createContenValueTemplate(tag), KEY_NAME + " = '" + tag.getTagID() + "'", null) == 0)
			System.out.println("EXCEPTION:  update Database");
		System.out.println("update RFIDTag DAO");
    }
    
    public void insert(RFIDTag tag){
    	if(this.getWritableDatabase().insert(TABLE_NAME, "tagid", this.createContenValueTemplate(tag)) == -1)
    		System.out.println("EXCEPTION:  insert Database");
    }
    
    public RFIDTag get(String tagid){
    	try{
    		Cursor cursor = this.getReadableDatabase().query(TABLE_NAME, new String[] {"tagid", "name", "threeg", "bluetooth", "wifi", "volume", "vibrate"}, "tagid = '" + tagid + "'", null, null, null, null);
    		cursor.moveToFirst();
    		RFIDTag tag = this.bindDataTemplate(cursor);
    		cursor.close();
    		return tag;
    	}
    	catch(Exception except){
    		System.out.println("get Database: " + except.toString());
    		return null;
    	}
    }
    
    public ArrayList<RFIDTag> getAll(){
    	try{
    		ArrayList<RFIDTag> array = new ArrayList<RFIDTag>();
    		Cursor cursor = this.getReadableDatabase().rawQuery(GETALL,null);
    		
    		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
    			array.add(this.bindDataTemplate(cursor));
    		
    		cursor.close();
    		
    		return array;
    	}
    	catch(Exception except){
    		System.out.println("getAll Database: " + except.toString());
    		return null;
    	}
    }
    
    public void delete(String tagid){
    	this.getWritableDatabase().delete(TABLE_NAME, KEY_NAME + "='" + tagid + "'", null);
    }
    
    public void deleteAll(){
    	this.getWritableDatabase().delete(TABLE_NAME, null, null);
    }
    
    private RFIDTag bindDataTemplate(Cursor cursor){
    	return new RFIDTag(cursor.getString(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6));
    }
    
    private ContentValues createContenValueTemplate(RFIDTag tag){
    	ContentValues values = new ContentValues();
    	values.put("tagid",tag.getTagID());
    	values.put("name",tag.getName());
    	values.put("threeg",tag.get3g());
    	values.put("bluetooth",tag.getBluetooth());
    	values.put("wifi",tag.getWifi());
    	values.put("volume",tag.getVolume());
    	values.put("vibrate",tag.getVibrate());
    	return values;
    }
}
