package com.example.rfidsettings.dao;

import android.content.Context;

public class Connect {
	private static Connect instance = null;
	private Connect(Context context){ }

	public static Connect getInstance(Context context){
		if (instance == null)
			instance = new Connect(context);
		return instance;
	}
	
}
