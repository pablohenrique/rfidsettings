package com.example.rfidsettings.model;

public class RFIDTag {

	//private variables
	String tagID = null;
	String name = null;
    boolean threeG;
    boolean bluetooth;
    boolean wifi;
    boolean volume;
    boolean vibrate;
    
	// constructor
    public RFIDTag(){ }
    
    public RFIDTag(String id){
    	this.tagID = id;
    }
    
    // constructor
	public RFIDTag(String tagid, String name, boolean threeG, boolean bluetooth, boolean wifi, boolean volume, boolean vibrate){
        this.setValues(tagid, name, threeG, bluetooth, wifi, volume, vibrate);
    }
	
	public RFIDTag(String tagid, String name, Integer threeG, Integer bluetooth, Integer wifi, Integer volume, Integer vibrate){
		this.setValues(tagid, name, threeG, bluetooth, wifi, volume, vibrate);
    }
	
	public void setValues(String tagid, String name, Object threeG, Object bluetooth, Object wifi, Object volume, Object vibrate){
		this.setTagID(tagid);
		this.setName(name);
		this.set3g(threeG);
		this.setBluetooth(bluetooth);
		this.setWifi(wifi);
		this.setVolume(volume);
		this.setVibrate(vibrate);
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
