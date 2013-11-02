package com.example.rfidsettings.dao;

public class TagObj {

	//private variables
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
    
	private boolean ConverIntegerBoolean(Integer i){
		return (i == 0) ? true : false;
	}
	
	private Integer ConverBooleanInteger(boolean b){
		return (b) ? 1 : 0;
	}
    
    // constructor
    public TagObj(String TagID, String name, boolean threeG, boolean bT, boolean wiFi, boolean volume, boolean vibrate){
        this._3g = threeG;
        this._bluetooth = bT;
        this._wifi = wiFi;
        this._volume = volume;
        this._vibrate = vibrate;
        this._name = name;
        this._tagid = TagID;
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
    
    public Integer get3g(){
        return this.ConverBooleanInteger(this._3g);
    }
     
    public Integer getBluetooth(){
        return this.ConverBooleanInteger(this._bluetooth);
    }
    
    public Integer getWifi(){
        return this.ConverBooleanInteger(this._wifi);
    }
    
    public Integer getVolume(){
        return this.ConverBooleanInteger(this._volume);
    }
    
    public Integer getVibrate(){
        return this.ConverBooleanInteger(this._vibrate);
    }
    
    /*
     * 
     */
    
    public boolean getB3g(){
        return this._3g;
    }
     
    public boolean getBBluetooth(){
        return this._bluetooth;
    }
    
    public boolean getBWifi(){
        return this._wifi;
    }
    
    public boolean getBVolume(){
        return this._volume;
    }
    
    public boolean getBVibrate(){
        return this._vibrate;
    }
    
    /*
     * 
     */
    
    public String getName(){
        return this._name;
    }
    
    public String getTagID(){
        return this._tagid;
    }
	
	public void set3g(int threeG) {
		this._3g = this.ConverIntegerBoolean(threeG);
	}
	
	public void setVolume(int volume) {
		this._volume = this.ConverIntegerBoolean(volume);
	}
	
	public void setWifi(int bT) {
		this._wifi = this.ConverIntegerBoolean(bT);
	}
	
	public void setVibrate(int vibrate) {
		this._vibrate = this.ConverIntegerBoolean(vibrate);		
	}
	
	public void setBluetooth(int bT) {
		this._bluetooth = this.ConverIntegerBoolean(bT);
	}
	
	public void setName(String name) {
		this._name = name;
	}
	
	public void setTagID(String tagid) {
		this._tagid = tagid;
	}
}
