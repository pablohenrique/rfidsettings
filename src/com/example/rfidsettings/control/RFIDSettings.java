package com.example.rfidsettings.control;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.example.rfidsettings.model.RFIDTag;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

public class RFIDSettings {
	private Context context;
	private WifiManager wifimgmt = null;
	private AudioManager audiomgmt = null;
	private BluetoothAdapter bluetoothmgmt = null;
	
	public RFIDSettings(Context cont){
		this.context = cont;
	}
	
	public void applyChanges(RFIDTag tag){
		this.changeBluetooth(tag.getBBluetooth());
		this.changeWifi(tag.getBWifi());
		if(tag.getBVibrate())
			this.changeVibrate(tag.getBVibrate());
		else
			this.changeVolume(tag.getBVolume());
	}
	
	private void changeWifi(boolean enabled){
		if(this.wifimgmt == null)
			this.wifimgmt = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);
		
		if(enabled)
			this.wifimgmt.setWifiEnabled(true);
		else
			this.wifimgmt.setWifiEnabled(false);
		this.wifimgmt.saveConfiguration();
	}
	
	private void changeVolume(boolean enabled){
		if(this.audiomgmt == null)
			this.audiomgmt = (AudioManager) this.context.getSystemService(Context.AUDIO_SERVICE);
		
		if(enabled)
			this.audiomgmt.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		else
			this.audiomgmt.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	
	private void changeVibrate(boolean enabled){
		if(this.audiomgmt == null)
			this.audiomgmt = (AudioManager) this.context.getSystemService(Context.AUDIO_SERVICE);
		
		if(enabled)
			this.audiomgmt.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		else
			this.audiomgmt.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	
	private void changeBluetooth(boolean enabled){
		if(this.bluetoothmgmt == null)
			this.bluetoothmgmt = BluetoothAdapter.getDefaultAdapter();
		
		if(enabled)
			this.bluetoothmgmt.enable();
		else
			this.bluetoothmgmt.disable();
	}
	private void changeMobileData(boolean enabled){
		try{
			ConnectivityManager dataMgmt = (ConnectivityManager)this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
			Method dataMtd = (Method)ConnectivityManager.class.getDeclaredMethod("setMobileDataEnabled", boolean.class).invoke(dataMgmt, true);
			dataMtd.setAccessible(true);
			dataMtd.invoke(dataMgmt, true);
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
	
	private void changeMap(boolean enabled){
		if(enabled){
			Intent intent = new Intent(Intent.ACTION_VIEW);
		    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
		    this.context.startActivity(intent);
		}
	}
}
