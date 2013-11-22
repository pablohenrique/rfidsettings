package com.example.rfidsettings.model;

public class RFIDTag {

	//private variables
	String tagID;
	String name;
    boolean threeG;
    boolean bluetooth;
    boolean wifi;
    boolean volume;
    boolean vibrate;
    
	// constructor
	public RFIDTag(){ }
    
    // constructor
	public RFIDTag(String TagID, String name, boolean threeG, boolean bT, boolean wiFi, boolean volume, boolean vibrate){
        this.threeG = threeG;
        this.bluetooth = bT;
        this.wifi = wiFi;
        this.volume = volume;
        this.vibrate = vibrate;
        this.name = name;
        this.tagID = TagID;
    }
	
	public RFIDTag(String TagID, String name, Integer threeG, Integer bluetooth, Integer wifi, Integer volume, Integer vibrate){
        this.threeG = this.ConverIntegerBoolean(threeG);
        this.bluetooth = this.ConverIntegerBoolean(bluetooth);
        this.wifi = this.ConverIntegerBoolean(wifi);
        this.volume = this.ConverIntegerBoolean(volume);
        this.vibrate = this.ConverIntegerBoolean(vibrate);
        this.name = name;
        this.tagID = TagID;
    }
    
    /*
     * Get methods return INTEGER
     */
    
    public Integer get3g(){
        return this.ConverBooleanInteger(this.threeG);
    }
     
    public Integer getBluetooth(){
        return this.ConverBooleanInteger(this.bluetooth);
    }
    
    public Integer getWifi(){
        return this.ConverBooleanInteger(this.wifi);
    }
    
    public Integer getVolume(){
        return this.ConverBooleanInteger(this.volume);
    }
    
    public Integer getVibrate(){
        return this.ConverBooleanInteger(this.vibrate);
    }
    
    /*
     * Get methods return BOOLEAN
     */
    
    public boolean getB3g(){
        return this.threeG;
    }
     
    public boolean getBBluetooth(){
        return this.bluetooth;
    }
    
    public boolean getBWifi(){
        return this.wifi;
    }
    
    public boolean getBVolume(){
        return this.volume;
    }
    
    public boolean getBVibrate(){
        return this.vibrate;
    }
    
    /*
     * Get methods return STRING
     */
    
    public String getName(){
        return this.name;
    }
    
    public String getTagID(){
        return this.tagID;
    }
    
    /*
     * Set methods
     */
    
	public void set3g(Object threeG) {
		this.threeG = (threeG instanceof Integer) ? this.ConverIntegerBoolean((Integer)threeG) : (Boolean)threeG;
	}
	
	public void setVolume(Object volume) {
		this.volume = (volume instanceof Integer) ? this.ConverIntegerBoolean((Integer)volume) : (Boolean)volume;
	}
	
	public void setWifi(Object wifi) {
		this.wifi = (wifi instanceof Integer) ? this.ConverIntegerBoolean((Integer)wifi) : (Boolean)wifi;
	}
	
	public void setVibrate(Object vibrate) {
		this.vibrate = (vibrate instanceof Integer) ? this.ConverIntegerBoolean((Integer)vibrate) : (Boolean)vibrate;		
	}
	
	public void setBluetooth(Object bluetooth) {
		this.bluetooth = (bluetooth instanceof Integer) ? this.ConverIntegerBoolean((Integer)bluetooth) : (Boolean)bluetooth;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTagID(String tagid) {
		this.tagID = tagid;
	}
	
	/*
	 * PRIVATE methods. Conversions.
	 */
	
	private boolean ConverIntegerBoolean(Integer i){
		return (i == 0) ? true : false;
	}
	
	private Integer ConverBooleanInteger(boolean b){
		return (b) ? 0 : 1;
	}
}
