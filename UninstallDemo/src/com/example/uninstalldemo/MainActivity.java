package com.example.uninstalldemo;

import com.notikum.notifypassive.UninstallSession;
import com.notikum.notifypassive.segmentIO.Properties;
import com.notikum.notifypassive.segmentIO.UninstallAnalytics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btn_event_one, btn_event_two;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		UninstallSession.init(MainActivity.this, 1);

		btn_event_one = (Button) findViewById(R.id.btn_event_one);
		btn_event_two = (Button) findViewById(R.id.btn_event_two);
		
		/*
		 * while sending a event, track key should be "eventName"
		 * */

		//sending a Event demo :
		btn_event_one.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				UninstallAnalytics.with(MainActivity.this).track("eventName", new Properties().putValue("ActivityScreen", "Login Screen"));
			}
		});
		//sending a Event demo :
		btn_event_two.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				UninstallAnalytics.with(MainActivity.this).track("eventName", new Properties().putValue("Signup", "Verified"));
			}
		});

	}

	@Override
	protected void onPause() {
		super.onPause();
		UninstallSession.appFocusChange();
	}
}
