package com.example.rfidsettings.model;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;

public class RFIDSettings {
	private static Context context;
	private static WifiManager wifimgmt = null;
	private static AudioManager audiomgmt = null;
	private static BluetoothAdapter bluetoothmgmt = null;
	
	public RFIDSettings(Context cont){
		context = cont;
	}
	
	public static void changeWifi(boolean enabled){
		if(wifimgmt == null)
			wifimgmt = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		
		if(enabled)
			wifimgmt.setWifiEnabled(true);
		else
			wifimgmt.setWifiEnabled(false);
		wifimgmt.saveConfiguration();
	}
	
	public static void changeVolume(boolean enabled){
		if(audiomgmt == null)
			audiomgmt = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		
		if(enabled)
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		else
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	
	public static void changeVibrate(boolean enabled){
		if(audiomgmt == null)
			audiomgmt = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		
		if(enabled)
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		else
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	
	public static void changeBluetooth(boolean enabled){
		if(bluetoothmgmt == null)
			bluetoothmgmt = BluetoothAdapter.getDefaultAdapter();
		
		if(enabled)
			bluetoothmgmt.enable();
		else
			bluetoothmgmt.disable();
	}
}
