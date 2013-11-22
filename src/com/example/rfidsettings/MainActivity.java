package com.example.rfidsettings;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rfidsettings.control.GlobalSingletonPool;
import com.example.rfidsettings.control.NFCForegroundUtil;
import com.example.rfidsettings.model.RFIDTag;

public class MainActivity extends Activity {
	static String TAG = "NFCREADER";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    //The two lines below is necessary for the well being of the project
	    GlobalSingletonPool.getInstance().setMainObjects(this);
	    
	    ///*
	    // 0 -> TRUE
	    // 1 -> FALSE
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-45-5615-79", "CardA", 0, 0, 0, 1, 0));
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-9370-47-100", "CardB", 0, 1, 1, 0, 1));
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-92-128850", "StickerA", 0, 0, 0, 0, 1));
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().insert(new RFIDTag("-10761850", "StickerB", 0, 1, 1, 0, 0));
	    for(RFIDTag elem : GlobalSingletonPool.getInstance().getRFIDTagDAO().getAll())
	    	System.out.println(elem.getName());
	    
	    /*
	    System.out.println(GlobalSingletonPool.getInstance().getRFIDTagDAO().get("-45-5615-79").getName());
	    GlobalSingletonPool.getInstance().getRFIDTagDAO().delete("-45-5615-79");
	    for(RFIDTag elem : GlobalSingletonPool.getInstance().getRFIDTagDAO().getAll())
	    	System.out.println(elem.getName());
	    
	    */
	    
	    setContentView(R.layout.activity_main);
	    //info = (TextView)findViewById(R.id.action_settings);
	}
	
	public void onPause() {
	    super.onPause();
	    GlobalSingletonPool.getInstance().getNFCForegroundUtil().disableForeground();
	}   

	public void onResume() {
	    super.onResume();
	    
	    //On resume, I have to reset the MainObjects. Reason: Thread onResume() is not the same as on onCreate() ''Fucking genius -.-
	    GlobalSingletonPool.getInstance().setMainObjects(this);
	    GlobalSingletonPool.getInstance().getNFCForegroundUtil().enableForeground();

	    if (!GlobalSingletonPool.getInstance().getNFCForegroundUtil().getNfc().isEnabled()){
	        Toast.makeText(getApplicationContext(), "Please activate NFC and press Back to return to the application!", Toast.LENGTH_LONG).show();
	        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	    }
	}
		
	public void onNewIntent(Intent intent) {
		GlobalSingletonPool.getInstance().setObject("tag",intent.getParcelableExtra(NfcAdapter.EXTRA_TAG));
		
	    StringBuilder sb = new StringBuilder();
		for(int i = 0; i < GlobalSingletonPool.getInstance().getTag().getId().length; i++){
	    	sb.append(Integer.valueOf(GlobalSingletonPool.getInstance().getTag().getId()[i]));
	    }
		
		// Get the RFIDSetting and applyChanges after getting the 'sb' RFIDTag from the Database
		GlobalSingletonPool.getInstance().getRFIDSettings().applyChanges(GlobalSingletonPool.getInstance().getRFIDTagDAO().get(sb.toString()));
	}
}