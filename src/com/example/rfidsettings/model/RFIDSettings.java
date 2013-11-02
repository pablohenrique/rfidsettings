package com.example.rfidsettings.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class RFIDSettings {
	//private static Context context;
	private static WifiManager wifimgmt = null;
	private static AudioManager audiomgmt = null;
	private static BluetoothAdapter bluetoothmgmt = null;
	
	public static void changeWifi(Context context){
		wifimgmt = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		if(wifimgmt.isWifiEnabled())
			wifimgmt.setWifiEnabled(false);
		else
			wifimgmt.setWifiEnabled(true);
		wifimgmt.saveConfiguration();
	}
	
	public static void changeWifi(Context context, boolean enabled){
		wifimgmt = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		if(enabled)
			wifimgmt.setWifiEnabled(true);
		else
			wifimgmt.setWifiEnabled(false);
		wifimgmt.saveConfiguration();
	}
	
	
	public static void changeVolume(Context context, boolean enabled){
		audiomgmt = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		if(enabled)
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		else
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	
	public static void changeVibrate(Context context, boolean enabled){
		audiomgmt = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		if(enabled)
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		else
			audiomgmt.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}
	
	public static void changeBluetooth(Context context, boolean enabled){
		bluetoothmgmt = BluetoothAdapter.getDefaultAdapter();
		if(enabled)
			bluetoothmgmt.enable();
		else
			bluetoothmgmt.disable();
	}
}
