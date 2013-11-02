package com.example.rfidsettings;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	static String TAG = "NFCREADER";

	NFCForegroundUtil nfcForegroundUtil = null;

	private TextView info;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    info = (TextView)findViewById(R.id.action_settings);

	    nfcForegroundUtil = new NFCForegroundUtil(this);
	}

	public void onPause() {
	    super.onPause();
	    nfcForegroundUtil.disableForeground();
	}   

	public void onResume() {
	    super.onResume();
	    nfcForegroundUtil.enableForeground();

	    if (!nfcForegroundUtil.getNfc().isEnabled())
	    {
	        Toast.makeText(getApplicationContext(), 
                    "Please activate NFC and press Back to return to the application!", 
                    Toast.LENGTH_LONG).show();
	        startActivity(
                    new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
	    }

	}

	public void onNewIntent(Intent intent) {
	    Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
	    /*StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < tag.getId().length; i++){
	    	sb.append(new Integer(tag.getId()[i]) + " ");
	    }*/
	    info.setText("TagID: " + bytesToHex(tag.getId()));    

	}

    /**
     *  Convenience method to convert a byte array to a hex string.
     *
     * @param  data  the byte[] to convert
     * @return String the converted byte[]
     */

    public static String bytesToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            buf.append(byteToHex(data[i]).toUpperCase());
            buf.append(" ");
        }
        return (buf.toString());
    }

    /**
     *  method to convert a byte to a hex string.
     *
     * @param  data  the byte to convert
     * @return String the converted byte
     */
    public static String byteToHex(byte data) {
        StringBuffer buf = new StringBuffer();
        buf.append(toHexChar((data >>> 4) & 0x0F));
        buf.append(toHexChar(data & 0x0F));
        return buf.toString();
    }

    /**
     *  Convenience method to convert an int to a hex char.
     *
     * @param  i  the int to convert
     * @return char the converted char
     */
    public static char toHexChar(int i) {
        if ((0 <= i) && (i <= 9)) {
            return (char) ('0' + i);
        } else {
            return (char) ('a' + (i - 10));
        }
    }    

}