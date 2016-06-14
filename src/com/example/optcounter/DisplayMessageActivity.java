package com.example.optcounter;

import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
//import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) throws ParseException{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String message1 = extras.getString("MESSAGE1");
		String message2 = extras.getString("MESSAGE2");
		String message3 = extras.getString("MESSAGE3");
		System.out.println(message1);
    	int i = Integer.parseInt(message1);
    	int j = Integer.parseInt(message2);
    	int k = Integer.parseInt(message3);
    	int days = 90;
    	Calendar y = Calendar.getInstance();
		y.set(Calendar.YEAR, k);
		y.set(Calendar.MONTH, i - 1);
		y.set(Calendar.DAY_OF_MONTH, j);    		
		Date z = y.getTime();
		Calendar t = Calendar.getInstance();
		t.set(Calendar.YEAR, k);
		t.set(Calendar.MONTH, i - 1);
		t.set(Calendar.DAY_OF_MONTH, j + days);    		
		Date v = t.getTime();
        Date x = new Date();    		
		long g = x.getTime() - z.getTime();
		long h = g / (24 * 60 * 60 * 1000);
		
	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(20);
	    textView.setText("The amount of days your OPT has been undergoing processing is: " + h + ". \n \n The "+ days +" days is due on: " + v);
	    // Set the text view as the activity layout
	    setContentView(textView);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_display_message,
					container, false);
			return rootView;
		}
	}

}
