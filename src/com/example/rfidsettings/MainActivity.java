package com.example.rfidsettings;

import com.example.rfidsettings.control.GlobalSingletonPool;
import com.example.rfidsettings.model.RFIDTag;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	static String TAG = "NFCREADER";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    //The two lines below is necessary for the well being of the project
	    GlobalSingletonPool.getInstance().setContext(this);
	    GlobalSingletonPool.getInstance().setObject("nfcforegroundutil",new NFCForegroundUtil(this));
	    
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-45-5615-79", "CardA", 0, 1, 1, 1, 0));
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-9370-47-100", "CardB", 0, 1, 1, 0, 1));
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-92-128850", "StickerA", 0, 1, 0, 1, 0));
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-10761850", "StickerB", 0, 0, 1, 0, 1));
	    
	    //System.out.println(GlobalSingletonPool.getInstance().getRFIDTagDAO().get("-45-5615-79").getName());
	    System.out.println(GlobalSingletonPool.getInstance().getRFIDTagDAO().getAll().toString());
	    
	    //GlobalSingletonPool.getInstance().getRFIDTagDAO().insert();
	    
	    //setContentView(R.layout.);
	    //info = (TextView)findViewById(R.id.action_settings);
	}
	
	public void onPause() {
	    super.onPause();
	    //GlobalSingletonPool.getInstance().getNFCForegroundUtil().disableForeground();
	}   

	public void onResume() {
	    super.onResume();
	    /*
	    GlobalSingletonPool.getInstance().getNFCForegroundUtil().enableForeground();

	    if (!GlobalSingletonPool.getInstance().getNFCForegroundUtil().getNfc().isEnabled()){
	        Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_LONG).show();
	        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	    }
	    */
	}
		
	public void onNewIntent(Intent intent) {
		/*
		GlobalSingletonPool.getInstance().setObject("tag",intent.getParcelableExtra(NfcAdapter.EXTRA_TAG));
	    StringBuilder sb = new StringBuilder();
		for(int i = 0; i < GlobalSingletonPool.getInstance().getTag().getId().length; i++){
	    	sb.append(Integer.valueOf(GlobalSingletonPool.getInstance().getTag().getId()[i]));
	    }
		System.out.println("On Intent: " + sb);
		
		/*
		GlobalSingletonPool.getInstance().getRFIDSettings().changeBluetooth(true);
		GlobalSingletonPool.getInstance().getRFIDSettings().changeWifi(true);
		GlobalSingletonPool.getInstance().getRFIDSettings().changeVibrate(true);
		
		MyDB mdb = (MyDB)GlobalSingletonPool.getInstance().getObject("mydb");
		mdb.post(new RFIDTag("-45-5615-79", "CardA", 0, 1, 1, 1, 0));
    	//mdb.post(new RFIDTag("-9370-47-100", "CardB", 0, 1, 1, 0, 1));
    	mdb.post(new RFIDTag("-92-128850", "StickerA", 0, 1, 0, 1, 0));
    	mdb.post(new RFIDTag("-10761850", "StickerB", 0, 0, 1, 0, 1));
    	*/
	}
}