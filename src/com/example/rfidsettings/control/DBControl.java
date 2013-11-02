package com.example.rfidsettings.control;

import java.util.ArrayList;

import android.content.Context;
import android.database.SQLException;
import com.example.rfidsettings.dao.Connect;
import com.example.rfidsettings.dao.TagObj;

public class DBControl{
	
	private Context context = null;
	public DBControl(Context context){
		this.context = context;
	}

	public ArrayList<String> Get(String rfid){
		try {

			 TagObj tagobjs = Connect.getDBhelper().getTagArray(rfid);

			if(tagobjs != null){
				//add new tag
			}
			else{
				//exec settings
				//tagobjs.
			}

		}catch(SQLException sqle){

			throw sqle;
		}
		return null;
	}
	
	public ArrayList<String> Get(){
		try {

			ArrayList<String> tagobjs = Connect.getDBhelper().getAll();
			
			//Show all Tags to edit

//			Spinner paredes = (Spinner) findViewById(R.id.spnParedes);
//			SpinnerAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, walls);
//			paredes.setAdapter(adapter);

		}catch(SQLException sqle){

			throw sqle;
		}
		return null;
	}
}
