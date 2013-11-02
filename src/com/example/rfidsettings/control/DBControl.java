package com.example.rfidsettings.control;

import java.util.ArrayList;

import android.database.SQLException;
import com.example.rfidsettings.dao.Connect;

public class DBControl{

	public ArrayList<String> Get(String rfid){
		try {

			ArrayList<String> tagobjs = Connect.getDBhelper().getTagArray(rfid);

			

		}catch(SQLException sqle){

			throw sqle;
		}
		return null;
	}
	
	public ArrayList<String> Get(){
		try {

			ArrayList<String> tagobjs = Connect.getDBhelper().getAll();

//			Spinner paredes = (Spinner) findViewById(R.id.spnParedes);
//			SpinnerAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, walls);
//			paredes.setAdapter(adapter);

		}catch(SQLException sqle){

			throw sqle;
		}
		return null;
	}
}
