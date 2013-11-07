package com.example.rfidsettings.dao;

import java.util.ArrayList;

import com.example.rfidsettings.model.RFIDTag;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDB{
	
	private MyDatabaseHelper dbHelper;  
	private SQLiteDatabase database;
	private Context context;
	
	public final String EMP_TABLE="Tags"; // name of table 
	public final String EMP_NAME="Name";  // name of employee
	public final String EMP_3G= "ThreeG";  // name of employee
	public final String EMP_BT="BT";  // name of employee
	public final String EMP_WIFI="Wifi";  // name of employee
	public final String EMP_VOLUME="Volume";  // name of employee
	public final String EMP_VIBRATE="Vibrate";  // name of employee
	public final String EMP_TAGID="TagID";  // name of employee
	public final String INSERT = "INSERT INTO " + EMP_TABLE + " ("+ EMP_TAGID + "," + EMP_NAME + "," + EMP_3G + "," + EMP_BT + "," +  EMP_WIFI + "," +  EMP_VOLUME + "," +  EMP_VIBRATE + ") VALUES('";
	public final String SELECT = "SELECT * FROM " + EMP_TABLE + " WHERE " + EMP_TAGID + " = '";
	public final String SELECTALL = "SELECT * FROM " + EMP_TABLE + ";";
	public final String DELETE = "DELETE FROM " + EMP_TABLE + " WHERE TagID='";
	public final String DELETEALL = "DELETE FROM " + EMP_TABLE + ";";
	public final String CREATEIFEXISTS = "CREATE TABLE IF NOT EXISTS " + EMP_TABLE + " (TagID VARCHAR(50) PRIMARY KEY, Name VARCHAR(50), ThreeG Integer, BT Integer, Wifi Integer, Volume Integer, Vibrate Integer)";
	public final String DROPTABLE = "DROP TABLE IF EXISTS " + EMP_TABLE;
	 
	public MyDB(Context context){  
		this.context = context;
		dbHelper = new MyDatabaseHelper(this.context);  
		database = dbHelper.getWritableDatabase();
		database.execSQL(this.DROPTABLE);
		database.execSQL(this.CREATEIFEXISTS);
	}
	
	public void post(RFIDTag tag){
		String sql = this.INSERT + tag.getTagID() + "','" + tag.getName() + "'," + tag.get3g() + "," + tag.getBluetooth() + "," + tag.getWifi() + "," + tag.getVolume() + "," + tag.getVibrate() + ")";
		database.execSQL(sql);
	}
	
	public RFIDTag get(String tagid) throws Exception{
		try{
			Cursor mCursor = database.rawQuery(this.SELECT + tagid + "';", null);
			mCursor.moveToFirst();
			RFIDTag tag = this.createRFIDTagTemplate(mCursor);
	        mCursor.close();
	        return tag;
		} catch(Exception except){
			throw new Exception("Error while GETTING RFIDTag: ", except);
		}
	}
	
	public ArrayList<RFIDTag> getAll(String tagid) throws Exception{
		try{
			ArrayList<RFIDTag> array = new ArrayList<RFIDTag>();
			Cursor mCursor = database.rawQuery(this.SELECTALL, null);
			
			while(mCursor.moveToNext())
				array.add(this.createRFIDTagTemplate(mCursor));
	        
			mCursor.close();
	        return array;
		} catch(Exception except){
			throw new Exception("Error while GETTING RFIDTag: ", except);
		}
	}
	
	public void delete(String TagID){
		database.execSQL(this.DELETE + TagID + "';");
	}
	
	public void deleteAll(){
		database.execSQL(this.DELETEALL);
	}
	
	public void ActivateChanges(RFIDTag tag){
		/*
		RFIDSettings.changeWifi(this.context, tag.getBWifi());
		RFIDSettings.changeBluetooth(this.context, tag.getBBluetooth());
		if(tag.getBVibrate() == true)
			RFIDSettings.changeVibrate(this.context, tag.getBVibrate());
		else
			RFIDSettings.changeVolume(this.context, tag.getBVolume());
		*/
	}
	
	public boolean RunRFID(String TagID){
		try {
			RFIDTag tag = this.get(TagID);
			if(tag == null)
				return false;
			else
				this.ActivateChanges(tag);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * PRIVATE methods. SQL helper
	 */
	private RFIDTag createRFIDTagTemplate(Cursor mCursor){
		return new RFIDTag(mCursor.getString(0),mCursor.getString(1),mCursor.getInt(2),mCursor.getInt(3),mCursor.getInt(4),mCursor.getInt(5),mCursor.getInt(6));
	}
}