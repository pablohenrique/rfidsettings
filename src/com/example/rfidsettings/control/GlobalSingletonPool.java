package com.example.rfidsettings.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;

import java.util.HashMap;

import com.example.rfidsettings.dao.RFIDTagDAO;

@SuppressLint("DefaultLocale")
public class GlobalSingletonPool {
	private static GlobalSingletonPool instance = null;
	private HashMap<String,Object> objectPool = new HashMap<String,Object>();
	
	/*
	 * PRIVATE Constructor
	 */
	private GlobalSingletonPool(){ }
	
	/*
	 * PUBLIC methods
	 */
	
	public static GlobalSingletonPool getInstance(){
		if(instance == null)
			instance = new GlobalSingletonPool();
		return instance;
	}
	
	public Object getObject(String key){
		return this.objectPool.get(key.toLowerCase());
	}
	
	public void setContextActivity(Context context, Activity activity){
		this.setObject("context", context);
		this.setObject("rfidsettings", new RFIDSettings(context));
		this.setObject("rfidtagdao", new RFIDTagDAO(context));
		this.setObject("nfcforegroundutil",new NFCForegroundUtil(activity));
	}
	
	public void setObject(String key, Object value){
		String aux = key.toLowerCase();
		if(objectPool.containsKey(aux))
			objectPool.remove(aux);
		objectPool.put(aux, value);
	}
	
	public NFCForegroundUtil getNFCForegroundUtil(){
		return (NFCForegroundUtil)this.getObject("nfcforegroundutil");
	}
	
	public Tag getTag(){
		return (Tag)this.getObject("tag");
	}
	
	public RFIDSettings getRFIDSettings(){
		return (RFIDSettings)this.getObject("rfidsettings");
	}
	
	public RFIDTagDAO getRFIDTagDAO(){
		return (RFIDTagDAO)this.getObject("rfidtagdao");
	}
	
	/*
	 * PRIVATE methods
	 */
}
