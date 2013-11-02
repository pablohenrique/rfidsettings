package com.example.rfidsettings;

import com.example.rfidsettings.control.MyDB;

import android.app.Application;
import android.content.Context;

public class GlobalVariables{
	private static StringBuilder globalSB = new StringBuilder();
	private static MyDB globalDB = null;
	private static Context globalContext = null;
	private static GlobalVariables singleInstance = null;
	
	private GlobalVariables(){ }
    
    public static GlobalVariables getInstance() {
        if(singleInstance != null)
            return singleInstance;
        else
            return new GlobalVariables();
    }
    
    public GlobalVariables setContext(Context context){
    	globalDB = new MyDB(context);
    	globalContext = context;
    	return singleInstance;
    }
    
    public static GlobalVariables setMyDB(MyDB mdb){
    	globalDB = mdb;
    	return singleInstance;
    }
    
    public static GlobalVariables setStringBuilder(StringBuilder sb){
    	globalSB = sb;
    	return singleInstance; 
    }
    
    public StringBuilder getStringBuilder(){
    	return globalSB; 
    }
    
    public static MyDB getMyDB(){
    	return globalDB;
    }
    
}
