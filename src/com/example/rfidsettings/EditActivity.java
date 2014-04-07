package com.example.rfidsettings;

import com.example.rfidsettings.control.GlobalSingletonPool;
import com.example.rfidsettings.model.RFIDTag;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EditActivity extends Activity {
	///*
	private ToggleButton toggleBluetooth = null;
	private ToggleButton toggleWifi = null;
	private ToggleButton toggleVolume = null;
	private ToggleButton toggleVibrate = null;
	private ToggleButton toggleMaps = null;
	private EditText fieldName = null; 
	private Button buttonDelete = null;
	private Button buttonSave = null;
	//*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editactivity);
		
		this.toggleBluetooth = (ToggleButton)this.findViewById(R.id.toggleButtonBluetooth);
		this.toggleWifi = (ToggleButton)this.findViewById(R.id.toggleButtonWifi);
		this.toggleVolume = (ToggleButton)this.findViewById(R.id.toggleButtonVolume);
		this.toggleVibrate = (ToggleButton)this.findViewById(R.id.toggleButtonVibrate);
		this.toggleMaps = (ToggleButton)this.findViewById(R.id.toggleButtonMaps);
		this.fieldName = (EditText)this.findViewById(R.id.editText1);
		
		this.registerToggleListeners();
		
		if(GlobalSingletonPool.getInstance().getActiveTag() != null && GlobalSingletonPool.getInstance().getActiveTag().getName() != null)
			this.modifyToggleButtons();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}
	
	private void modifyToggleButtons(){
		RFIDTag tag = (RFIDTag)GlobalSingletonPool.getInstance().getObject("activetag");
		this.toggleBluetooth.setChecked(tag.getBBluetooth());
		this.toggleWifi.setChecked(tag.getBWifi());
		this.toggleVolume.setChecked(tag.getBVolume());
		this.toggleVibrate.setChecked(tag.getBVibrate());
		this.fieldName.setText(tag.getName());
	}
	
	private void registerToggleListeners(){
		/*
		this.addToggleBluetoothListener();
		this.addToggleWifiListener();
		this.addToggleVibrateListener();
		this.addToggleVolumeListener();
		*/
		this.addDeleteButtonListener();
		this.addSaveButtonListener();
	}

	/*
	private void addToggleBluetoothListener(){
		this.toggleBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked)
					tag.setBluetooth(true);
				else
					tag.setBluetooth(false);
				GlobalSingletonPool.getInstance().deleteObject("activetag");
				GlobalSingletonPool.getInstance().setObject("activetag", tag);
				
			}
		});
	}
	
	private void addToggleWifiListener(){
		this.toggleWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked)
					tag.setWifi(true);
				else
					tag.setWifi(false);
				GlobalSingletonPool.getInstance().setObject("activetag", tag);
			}
		});
	}
	
	private void addToggleVolumeListener(){
		this.toggleBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked)
					tag.setVolume(true);
				else
					tag.setVolume(false);
				GlobalSingletonPool.getInstance().setObject("activetag", tag);
			}
		});
	}
	
	private void addToggleVibrateListener(){
		this.toggleBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked)
					tag.setVibrate(true);
				else
					tag.setVibrate(false);
				GlobalSingletonPool.getInstance().setObject("activetag", tag);
			}
		});
	}
	*/
	private void addDeleteButtonListener(){
		this.buttonDelete = (Button)this.findViewById(R.id.deleteAll);
		this.buttonDelete.setOnClickListener(new Button.OnClickListener()
            {
            public void onClick(View v)
                {
            		GlobalSingletonPool.getInstance().getRFIDTagDAO().delete(GlobalSingletonPool.getInstance().getActiveTag().getTagID());
            		GlobalSingletonPool.getInstance().deleteObject("activetag");
            		Intent intent = new Intent(EditActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        );
	}
	
	private void addSaveButtonListener(){
		this.buttonDelete = (Button)this.findViewById(R.id.saveAll);
		this.buttonDelete.setOnClickListener(new Button.OnClickListener()
            {
            public void onClick(View v)
                {
            		String tagName = fieldName.getText().toString().trim();
            		if(tagName == "Give this tag a name" || tagName == "")
            			Toast.makeText(getApplicationContext(), "Please, give this tag a name", Toast.LENGTH_LONG).show();
            		else{
            			System.out.println("SavedButton: 0");
            			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
            			
            			if(tag.getName() == null){
            				tag.setValues(tag.getTagID(), tagName, true, toggleBluetooth.isChecked(), toggleWifi.isChecked(), toggleVolume.isChecked(), toggleVibrate.isChecked());
                			GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(tag);
                			GlobalSingletonPool.getInstance().setObject("activetag", tag);
            			}else {
	            			tag.setValues(tag.getTagID(), tagName, true, toggleBluetooth.isChecked(), toggleWifi.isChecked(), toggleVolume.isChecked(), toggleVibrate.isChecked());
	            			GlobalSingletonPool.getInstance().getRFIDTagDAO().update(tag);
	            			GlobalSingletonPool.getInstance().setObject("activetag", tag);
            			}
            			System.out.println("SavedButton: 1");
            		}
                }
            }
        );
	}
	
	/*
	private void addEditTextListener(){
		this.fieldName.setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
		        if(hasFocus){
		        	if(fieldName.getText().toString() == "Give this tag a name" || fieldName.getText().toString() == ""){
		        		Toast.makeText(getApplicationContext(), "Please, give this tag a name", Toast.LENGTH_LONG).show();
		        	}else{
		        		RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
		        		tag.setName(fieldName.getText().toString());
		        		GlobalSingletonPool.getInstance().setObject("activetag", tag);
		        	}
		        }
		    }
	    });
	}
	*/
}
