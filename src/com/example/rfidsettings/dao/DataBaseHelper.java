package com.example.rfidsettings.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static final String TABLE_TAGS = "Tags";

	private static final String COLUMN_TAGID = "TagID";

	//The Android's default system path of your application database.
	@SuppressLint("SdCardPath")
	private static String DB_PATH = "";//"/data/data/com.example.rfidsettings/databases/";

	private static String DB_NAME = "Tags";

	private SQLiteDatabase myDataBase; 

	private final Context myContext;

	/**
	 * Constructor
	 * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
	 * @param context
	 */
	public DataBaseHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.myContext = context;
		DB_PATH = this.myContext.getFilesDir().getPath() + "/data/data/com.example.rfidsettings/databases";
		
		try {
			this.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DataBaseHelper.DB_PATH = myContext.getFilesDir().getPath() + "data/com.herokuapp.climbingtracker/databases/";
	}	

	/**
	 * Creates a empty database on the system and rewrites it with your own database.
	 * */
	public void createDataBase() throws IOException{

		boolean dbExist = checkDataBase();

		if(dbExist){
			//do nothing - database already exist
		}else{

			//By calling this method and empty database will be created into the default system path
			//of your application so we are gonna be able to overwrite that database with our database.
			this.getReadableDatabase();

			try {

				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");

			}
		}

	}

	/**
	 * Check if the database already exist to avoid re-copying the file each time you open the application.
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase(){

		SQLiteDatabase checkDB = null;

		try{
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

		}catch(SQLiteException e){

			//database does't exist yet.

		}

		if(checkDB != null){

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created empty database in the
	 * system folder, from where it can be accessed and handled.
	 * This is done by transfering bytestream.
	 * */
	private void copyDataBase() throws IOException{

		//Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		//Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		//transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer))>0){
			myOutput.write(buffer, 0, length);
		}

		//Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	public void openDataBase() throws SQLException{

		//Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

	}

	@Override
	public synchronized void close() {

		if(myDataBase != null)
			myDataBase.close();

		super.close();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public TagObj findTag(String tagID) {
		String query = "Select * FROM " + TABLE_TAGS + " WHERE " + COLUMN_TAGID + " =  \"" + tagID + "\"";

		openDataBase();

		Cursor cursor = myDataBase.rawQuery(query, null);

		TagObj tag = new TagObj();

		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			tag.setID(Integer.parseInt(cursor.getString(0)));
			tag.setName(cursor.getString(1));
			tag.set3g(Integer.parseInt(cursor.getString(2)));
			tag.setBluetooth(Integer.parseInt(cursor.getString(3)));
			tag.setWifi(Integer.parseInt(cursor.getString(4)));
			tag.setVolume(Integer.parseInt(cursor.getString(5)));
			tag.setVibrate(Integer.parseInt(cursor.getString(6)));
			tag.setTagID(cursor.getString(7));
			cursor.close();
		} else {
			tag = null;
		}
		close();
		return tag;
	}

	public TagObj getTagArray(String tagID) {
		String query = "Select * FROM " + TABLE_TAGS + " WHERE " + COLUMN_TAGID + " =  \"" + tagID + "\"";

		openDataBase();

		Cursor cursor = myDataBase.rawQuery(query, null);

		TagObj tag = new TagObj();

		while (cursor.moveToNext()) {
			tag._name = cursor.getString(1);
			tag._3g = ((Integer.parseInt(cursor.getString(2)))==1);
			tag._bluetooth = ((Integer.parseInt(cursor.getString(3)))==1);
			tag._wifi = ((Integer.parseInt(cursor.getString(4)))==1);
			tag._volume = ((Integer.parseInt(cursor.getString(5)))==1);
			tag._vibrate = ((Integer.parseInt(cursor.getString(6)))==1);
		}
		cursor.close();
		close();
		return tag;
	}
	
	public ArrayList<String> getAll() {
		String query = "Select * FROM " + TABLE_TAGS + "\"";

		openDataBase();

		Cursor cursor = myDataBase.rawQuery(query, null);

		ArrayList<String> tags = new ArrayList<String>();

		while (cursor.moveToNext()) {
			tags.add(cursor.getString(3));
		}
		cursor.close();
		close();
		return tags;
	}
	
	public void addTag(String tagID, Boolean wifi, Boolean threeG, Boolean vibration, int volume, String Name, Boolean bT){
		String ThreeG = threeG?"1":"0";
		String BT = bT?"1":"0";
		String Wifi = wifi?"1":"0";
		String Vibration = vibration?"1":"0";
		String Volume = Integer.toString(volume);
		String query = "INSERT INTO "+TABLE_TAGS+" (ThreeG, BT, Wifi, Volume, Vibrate, TagId) "+" VALUES "+"("+ThreeG+","+BT+","+Wifi+","+Volume+","+Vibration+") " + "\"";

		openDataBase();
		
		this.myDataBase.execSQL(query);
	}
	
	public void deleteTag(String TagID){
		String query = "DELETE FROM "+TABLE_TAGS+" WHERE TagID="+TagID+"\"";
		
		openDataBase();
		
		this.myDataBase.execSQL(query);
	}

}
