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
    String _tagid;
     
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
    
    public String getTagID(){
        return this._tagid;
    }
    
	public void setID(int id) {
		this._id = id;
	}
	
	public void set3g(int threeG) {
		this._3g = (threeG == 1);
	}
	
	public void setVolume(int volume) {
		this._volume = (volume == 1);
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
	
	public void setName(String name) {
		this._name = name;
	}
	
	public void setTagID(String tagid) {
		this._tagid = tagid;
	}
}
