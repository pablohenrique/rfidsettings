package com.example.rfidsettings.dao;

public class TagObj {

	//private variables
    int _id;
    Boolean _threeG;
    Boolean _bT;
    Boolean _wiFi;
    int _volume;
    boolean _vibrate;
    String _name;
     
    // Empty constructor
    public TagObj(){
         
    }
    // constructor
    public TagObj(int id, Boolean threeG, Boolean bT, Boolean wiFi, int volume, boolean vibrate, String name){
        this._id = id;
        this._threeG = threeG;
        this._bT = bT;
        this._wiFi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
        this._name = name;
    }
     
    // constructor
    public TagObj(Boolean threeG, Boolean bT, Boolean wiFi, int volume, boolean vibrate, String name){
        this._threeG = threeG;
        this._bT = bT;
        this._wiFi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
        this._name = name;
    }
    
    public int getID(){
        return this._id;
    }
     
    public Boolean getthreeG(){
        return this._threeG;
    }
     
    public Boolean getbT(){
        return this._bT;
    }
    
    public Boolean getwiFi(){
        return this._wiFi;
    }
    
    public int getvolume(){
        return this._volume;
    }
    
    public boolean getvibrate(){
        return this._vibrate;
    }
    
    public String getname(){
        return this._name;
    }
    
	public void setID(int id) {
		this._id = id;
	}
	
	public void setthreeG(int threeG) {
		this._threeG = (threeG == 1);
	}
	
	public void setvolume(int volume) {
		this._volume = volume;
	}
	
	public void setwiFi(int bT) {
		this._bT = (bT == 1);
	}
	
	public void setvibrate(int vibrate) {
		this._vibrate = (vibrate == 1);		
	}
	
	public void setbT(int bT) {
		this._bT = (bT == 1);
	}
	
	public void setbT(String bT) {
		this._name = bT;
	}
}
