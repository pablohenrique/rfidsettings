package com.example.rfidsettings;

import com.example.rfidsettings.control.GlobalSingletonPool;
import com.example.rfidsettings.dao.Connect;
import com.example.rfidsettings.dao.MyDB;
import com.example.rfidsettings.model.RFIDTag;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	static String TAG = "NFCREADER";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    GlobalSingletonPool.getInstance().setObject("nfcforegroundutil",new NFCForegroundUtil(this));
	    GlobalSingletonPool.getInstance().setObject("stringbuilder", new StringBuilder());
	    setContentView(R.layout.activity_main);
	    //info = (TextView)findViewById(R.id.action_settings);
	}
	/*
	public void onPause() {
	    super.onPause();
	    nfcForegroundUtil.disableForeground();
	}   

	public void onResume() {
	    super.onResume();
	    nfcForegroundUtil.enableForeground();

	    if (!nfcForegroundUtil.getNfc().isEnabled()){
	        Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_LONG).show();
	        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	    }

	}
	*/
	
	/*	
	public void onNewIntent(Intent intent) {
		Connect.getInstance(this);
	    Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		for(int i = 0; i < tag.getId().length; i++){
	    	globalVar.getStringBuilder().append(Integer.valueOf(tag.getId()[i]));
	    }
		System.out.println(globalVar.getStringBuilder());
	}
	*/
	
	/*
	public void onNewIntent(Intent intent) {
	    Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
	    sb = new StringBuilder();
	    for(int i = 0; i < tag.getId().length; i++){
	    	sb.append(Integer.valueOf(tag.getId()[i]));
	    }
	    System.out.println(sb);
	    mdb = new MyDB(this);
    	mdb.deleteAll();
    	///                 					  3  B  W  V  T /
    	mdb.post(new RFIDTag("-45-5615-79", "CardA", 0, 1, 1, 1, 0));
    	//mdb.post(new RFIDTag("-9370-47-100", "CardB", 0, 1, 1, 0, 1));
    	mdb.post(new RFIDTag("-92-128850", "StickerA", 0, 1, 0, 1, 0));
    	mdb.post(new RFIDTag("-10761850", "StickerB", 0, 0, 1, 0, 1));
    	System.out.println("OK");
	    
	    if(!mdb.RunRFID(sb.toString())){
	    	//setContentView(R.layout.addtag);
	    }
	}
	*/
	
	/*
	public void btnGravarClicked(View view){
		System.out.println("Antes: " + sb.toString());
		
		EditText txtName = (EditText) findViewById(R.id.txtName);
		CheckBox chkWifi = (CheckBox) findViewById(R.id.chkWifi);
		CheckBox chkBlueTooth = (CheckBox) findViewById(R.id.chkBlueTooth);
		CheckBox chkVolume = (CheckBox) findViewById(R.id.chkVolume);
		CheckBox chkVibration = (CheckBox) findViewById(R.id.chkVib);
		
		System.out.println(sb.toString());
		
		mdb.createRecords(sb.toString(), txtName.getText().toString(), false, chkBlueTooth.isChecked(), chkWifi.isChecked(), chkVolume.isChecked(), chkVibration.isChecked());
		
		setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main);
		
    }
	*/

    /*
     *  Convenience method to convert a byte array to a hex string.
     *
     * @param  data  the byte[] to convert
     * @return String the converted byte[]
     */
	/*
    public static String bytesToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            buf.append(byteToHex(data[i]).toUpperCase(Locale.getDefault()));
            buf.append(" ");
        }
        return (buf.toString());
    }
	*/
    /*
     *  method to convert a byte to a hex string.
     *
     * @param  data  the byte to convert
     * @return String the converted byte
     */
    /*
	public static String byteToHex(byte data) {
        StringBuffer buf = new StringBuffer();
        buf.append(toHexChar((data >>> 4) & 0x0F));
        buf.append(toHexChar(data & 0x0F));
        return buf.toString();
    }
	*/
    /*
     *  Convenience method to convert an int to a hex char.
     *
     * @param  i  the int to convert
     * @return char the converted char
     */
	/*
    public static char toHexChar(int i) {
        if ((0 <= i) && (i <= 9)) {
            return (char) ('0' + i);
        } else {
            return (char) ('a' + (i - 10));
        }
    }
    */
}