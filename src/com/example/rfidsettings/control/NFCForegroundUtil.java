package com.example.rfidsettings.control;
/**/
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcA;
import android.util.Log;

public class NFCForegroundUtil {
	private NfcAdapter nfc;
	private Activity activity;
	private IntentFilter intentFiltersArray[];
	private PendingIntent intent;
	private String techListsArray[][];

	public NFCForegroundUtil(Activity activity) {
	    super();
	    
	    this.activity = activity; 
	    this.nfc = NfcAdapter.getDefaultAdapter(activity.getApplicationContext());
	    this.intent = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

	    IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);

	    try {
	        ndef.addDataType("*/*");
	    } catch (MalformedMimeTypeException e) {
	        throw new RuntimeException("Unable to speciy */* Mime Type", e);
	    }
	    
	    try{
	    	intentFiltersArray = new IntentFilter[] { ndef };
		    techListsArray = new String[][] { new String[] { NfcA.class.getName() } };
	    } catch(Exception exc){
	    	System.out.println(exc.toString());
	    }

	}

	public void enableForeground()
	{
	    Log.d("demo", "Foreground NFC dispatch enabled");
	    this.nfc.enableForegroundDispatch(activity, intent, intentFiltersArray, techListsArray);
	}

	public void disableForeground()
	{
	    Log.d("demo", "Foreground NFC dispatch disabled");
	    this.nfc.disableForegroundDispatch(activity);
	}

	public NfcAdapter getNfc() {
	    return this.nfc;
	}   
}