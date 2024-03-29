package com.example.rss_feed;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;


public class DetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		String title 	= (String)getIntent().getExtras().get("title");
		String content 	= (String)getIntent().getExtras().get("summary");
		

		Log.d("DEBUG", "title:\t" + title);

		Log.d("DEBUG", "content:\t\t" + content);
		
		
		TextView titleTV = (TextView)findViewById(R.id.detailsTextView);
		WebView webView	 = (WebView)findViewById(R.id.detailsWebView);
		
		titleTV.setText(title);
		webView.loadData(content, "text/html", "UTF-8");
		
	}

	
}