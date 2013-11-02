package com.example.rfidsettings.control;

import com.example.rfidsettings.dao.MyDatabaseHelper;
import com.example.rfidsettings.dao.TagObj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDB{  

	private MyDatabaseHelper dbHelper;  

	private SQLiteDatabase database;  

	public final static String EMP_TABLE="Tags"; // name of table 

	public final static String EMP_ID="_id"; // id value for employee
	public final static String EMP_NAME="Name";  // name of employee
	public final static String EMP_3G= "ThreeG";  // name of employee
	public final static String EMP_BT="BT";  // name of employee
	public final static String EMP_WIFI="Wifi";  // name of employee
	public final static String EMP_VOLUME="Volume";  // name of employee
	public final static String EMP_VIBRATE="Vibrate";  // name of employee
	public final static String EMP_TAGID="TagID";  // name of employee
	/** 
	 * 
	 * @param context 
	 */  
	public MyDB(Context context){  
		dbHelper = new MyDatabaseHelper(context);  
		database = dbHelper.getWritableDatabase();  
	}


	public long createRecords(String name, boolean tg, boolean bt, boolean wifi, boolean volume, boolean vibrate, String tagid){  
		ContentValues values = new ContentValues();  
		//values.put(EMP_ID, "DEFAULT");  
		values.put(EMP_NAME, name);
		values.put(EMP_3G, tg);
		values.put(EMP_BT, bt);
		values.put(EMP_WIFI, wifi);
		values.put(EMP_VOLUME, volume);
		values.put(EMP_VIBRATE,vibrate);
		values.put(EMP_TAGID,tagid);
		return database.insert(EMP_TABLE, null, values);  
	}    

	public TagObj selectRecords() {
		String[] cols = new String[] {EMP_ID, EMP_NAME, EMP_3G, EMP_BT, EMP_WIFI, EMP_VOLUME, EMP_VIBRATE, EMP_TAGID};  
		Cursor mCursor = database.query(true, EMP_TABLE, cols, null, null, null, null, null, null);
		TagObj tag = new TagObj();
		if (mCursor != null){
			mCursor.moveToFirst();
			//tag.setID(Integer.parseInt(mCursor.getString(0)));
            tag.setName(mCursor.getString(1));
            tag.set3g(Integer.parseInt(mCursor.getString(2)));
            tag.setBluetooth(Integer.parseInt(mCursor.getString(3)));
            tag.setWifi(Integer.parseInt(mCursor.getString(4)));
            tag.setVolume(Integer.parseInt(mCursor.getString(5)));
            tag.setVibrate(Integer.parseInt(mCursor.getString(6)));
            tag.setTagID(mCursor.getString(7));
            mCursor.close();
		}
		return tag; // iterate to get each value.
	}

}