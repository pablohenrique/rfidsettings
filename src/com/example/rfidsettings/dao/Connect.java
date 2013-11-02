package com.example.rfidsettings.dao;

import java.io.IOException;
import android.content.Context;
import android.database.SQLException;

public class Connect {

	private static DataBaseHelper DBhelper = null;
	private static Connect instance = null;
	private Connect(Context context){
		DBhelper = new DataBaseHelper(context); 

		try {
			DBhelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");
		}
		try {
			DBhelper.openDataBase();
		}
		catch(SQLException sqle){
			throw sqle;
		}
	}

	public static Connect getInstance(Context context){
		if (instance == null)
			instance = new Connect(context);
		return instance;

	}

	public static DataBaseHelper getDBhelper(){
		return DBhelper;
	}
}
