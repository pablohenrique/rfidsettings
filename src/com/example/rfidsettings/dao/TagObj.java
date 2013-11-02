package com.example.rfidsettings.dao;

public class TagObj {

	//private variables
    int _id;
    boolean _3g;
    boolean _bluetooth;
    boolean _wifi;
    boolean _volume;
    boolean _vibrate;
    String _name;
     
    // Empty constructor
    public TagObj(){
         
    }
    // constructor
    public TagObj(int id, boolean threeG, boolean bT, boolean wiFi, boolean volume, boolean vibrate, String name){
        this._id = id;
        this._3g = threeG;
        this._bluetooth = bT;
        this._wifi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
        this._name = name;
    }
     
    // constructor
    public TagObj(boolean threeG, boolean bT, boolean wiFi, boolean volume, boolean vibrate, String name){
        this._3g = threeG;
        this._bluetooth = bT;
        this._wifi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
        this._name = name;
    }
    
    public int getID(){
        return this._id;
    }
     
    public boolean get3g(){
        return this._3g;
    }
     
    public boolean getBluetooth(){
        return this._bluetooth;
    }
    
    public boolean getWifi(){
        return this._wifi;
    }
    
    public boolean getVolume(){
        return this._volume;
    }
    
    public boolean getVibrate(){
        return this._vibrate;
    }
    
    public String getName(){
        return this._name;
    }
    
	public void setID(int id) {
		this._id = id;
	}
	
	public void set3g(int threeG) {
		this._3g = (threeG == 1);
	}
	
	public void setVolume(boolean volume) {
		this._volume = volume;
	}
	
	public void setWifi(int bT) {
		this._bluetooth = (bT == 1);
	}
	
	public void setVibrate(int vibrate) {
		this._vibrate = (vibrate == 1);		
	}
	
	public void setBluetooth(int bT) {
		this._bluetooth = (bT == 1);
	}
	
	public void setBluetooth(String bT) {
		this._name = bT;
	}
}
