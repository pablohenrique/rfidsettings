package com.example.rfidsettings;

import com.example.rfidsettings.control.GlobalSingletonPool;
import com.example.rfidsettings.model.RFIDTag;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class EditActivity extends Activity {
	///*
	private ToggleButton toggleBluetooth = null;
	private ToggleButton toggleWifi = null;
	private ToggleButton toggleVolume = null;
	private ToggleButton toggleVibrate = null;
	private ToggleButton toggleMaps = null;
	private EditText fieldName = null; 
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
		
		//this.registerToggleListeners();
		
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
		this.addToggleBluetoothListener();
		this.addToggleWifiListener();
		this.addToggleVibrateListener();
		this.addToggleVolumeListener();
	}
	
	private void addToggleBluetoothListener(){
		this.toggleBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked)
					tag.setBluetooth(true);
				else
					tag.setBluetooth(false);
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
	/*
	private void addEditTextListener(){
		this.fieldName.setOnFocusChangeListener(new OnFocusChangeListener(){
			RFIDTag tag = GlobalSingletonPool.getInstance().getActiveTag();
			
			@Override
			public void onFocusChangeListener(){
				if(!isFocused)
					tag.setName(fieldName.getText().toString());
				GlobalSingletonPool.getInstance().setObject("activetag", tag);
			}
		});
	}
	*/
}
