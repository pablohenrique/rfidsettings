package com.example.rfidsettings;

public class Tag {

	//private variables
    int _id;
    Boolean _threeG;
    Boolean _lTE;
    Boolean _wiFi;
    int _volume;
    boolean _vibrate;
     
    // Empty constructor
    public Tag(){
         
    }
    // constructor
    public Tag(int id, Boolean threeG, Boolean lTE, Boolean wiFi, int volume, boolean vibrate){
        this._id = id;
        this._threeG = threeG;
        this._lTE = lTE;
        this._wiFi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
    }
     
    // constructor
    public Tag(Boolean threeG, Boolean lTE, Boolean wiFi, int volume, boolean vibrate){
        this._threeG = threeG;
        this._lTE = lTE;
        this._wiFi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
    }
    
    public int getID(){
        return this._id;
    }
     
    public Boolean getthreeG(){
        return this._threeG;
    }
     
    public Boolean getlTE(){
        return this._lTE;
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
    
	public void setID(int id) {
		this._id = id;
	}
	
	public void setthreeG(int threeG) {
		this._threeG = (threeG == 1);
	}
	
	public void setvolume(int volume) {
		this._volume = volume;
	}
	
	public void setwiFi(int lTE) {
		this._lTE = (lTE == 1);
	}
	
	public void setvibrate(int vibrate) {
		this._vibrate = (vibrate == 1);		
	}
	
	public void setlTE(int lTE) {
		this._lTE = (lTE == 1);
	}
}
