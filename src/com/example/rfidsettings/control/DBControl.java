package com.example.rfidsettings.control;

import java.util.ArrayList;

import android.content.Context;
import android.database.SQLException;
import com.example.rfidsettings.dao.Connect;
import com.example.rfidsettings.dao.TagObj;
import com.example.rfidsettings.model.RFIDSettings;

public class DBControl{
	
	private Context context = null;
	public DBControl(Context context){
		this.context = context;
	}
	
	private void executeChangesTemplate(TagObj tagobjs){
		RFIDSettings.changeBluetooth(this.context, tagobjs.getBluetooth());
		RFIDSettings.changeWifi(this.context, tagobjs.getWifi());
		RFIDSettings.changeVibrate(this.context, tagobjs.getVibrate());
		RFIDSettings.changeVolume(this.context, tagobjs.getVolume());
	}

	public ArrayList<String> Get(String rfid){
		try {

			 TagObj tagobjs = Connect.getDBhelper().getTagArray(rfid);

			if(tagobjs != null){
				this.executeChangesTemplate(tagobjs);
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

			ArrayList<TagObj> tagobjs = Connect.getDBhelper().getAll();
			
			for(TagObj aux : tagobjs)
				this.executeChangesTemplate(aux);
			
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
